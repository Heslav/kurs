package pl.programming4you.lectures5.lecture9.task18;

import java.util.ArrayList;
import java.util.List;

public class Charity implements Lottery {
    List<Player> players = new ArrayList<>();

    @Override
    public List<Player> getWinners() {
        return players;
    }

    @Override
    public void play(Player player) {
        players.add(player);
    }
}
