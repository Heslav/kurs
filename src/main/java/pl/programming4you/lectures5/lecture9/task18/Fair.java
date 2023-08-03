package pl.programming4you.lectures5.lecture9.task18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Fair implements Lottery {
    private final List<Player> players = new ArrayList<>();

    @Override
    public List<Player> getWinners() {
        List<Player> winners = new ArrayList<>(players);
        Collections.shuffle(winners);

        Random random = new Random();
        int randomNumber = random.nextInt(0, players.size() + 1);
        return winners.subList(0, randomNumber);
    }

    @Override
    public void play(Player player) {
        players.add(player);
    }
}
