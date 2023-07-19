package pl.programming4you.lectures5.lecture9.task18;


import java.util.List;
import java.util.stream.Collectors;

public class Task18 {
    public static void main(String[] args) {
        Fair fairLottery = new Fair();
        fairLottery.play(new Player("Rysiu"));
        fairLottery.play(new Player("Marek"));
        fairLottery.play(new Player("Tadek"));

        Casino casinoLottery = new Casino();
        casinoLottery.play(new Player("Rysiu"));
        casinoLottery.play(new Player("Marek"));
        casinoLottery.play(new Player("Tadek"));

        Charity charityLottery = new Charity();
        charityLottery.play(new Player("Rysiu"));
        charityLottery.play(new Player("Marek"));
        charityLottery.play(new Player("Tadek"));

        printWinners(fairLottery);
        printWinners(charityLottery);
        printWinners(casinoLottery);

    }

    private static void printWinners(Lottery lottery) {
        List<Player> winners = lottery.getWinners();
        if (winners.isEmpty()) {
            System.out.println("Sorry, there were no winners this time!");
        } else {
            System.out.println("The winners are: " + winners.stream().map(player -> player.getName()).collect(Collectors.joining(", ")));
        }
    }

}
