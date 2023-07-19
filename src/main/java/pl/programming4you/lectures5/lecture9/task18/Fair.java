package pl.programming4you.lectures5.lecture9.task18;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fair implements Lottery {
    private final List<Player> players = new ArrayList<>();

    @Override
    public List<Player> getWinners() {
        List<Player> winners = new ArrayList<>();
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < players.size(); i++) {
            int randomNumber = random.nextInt(players.size());

            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
                winners.add(players.get(randomNumber));
            }
        }
        return winners;
    }

    @Override
    public void play(Player player) {
        players.add(player);
    }
}
