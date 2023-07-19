package pl.programming4you.lectures5.lecture9.task18;

import java.util.List;

public interface Lottery {
    List<Player> getWinners();

    void play(Player player);
}

