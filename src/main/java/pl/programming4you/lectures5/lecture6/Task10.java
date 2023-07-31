package pl.programming4you.lectures5.lecture6;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        creatingNickName();
    }

    private static void creatingNickName() {
        System.out.println("Welcome to the super extra nickname generator.");
        Faker faker = new Faker();
        Random random = new Random();
        int randomThreeNumbers = random.nextInt(100, 1000);
        Scanner scanner = new Scanner(System.in);
        boolean stopper = true;

        while (stopper) {
            System.out.println("What do you like most? gameofthrones, witcher or harrypotter?: ");
            String userPick = scanner.nextLine().toLowerCase();
            switch (userPick) {
                case "witcher":
                    System.out.println(faker.witcher().character().replace(" ", "").toLowerCase(Locale.ROOT) + randomThreeNumbers);
                    stopper = false;
                    break;
                case "gameofthrones":
                    System.out.println(faker.gameOfThrones().character().replace(" ", "").toLowerCase(Locale.ROOT) + randomThreeNumbers);
                    stopper = false;
                    break;
                case "harrypotter":
                    System.out.println(faker.harryPotter().character().replace(" ", "").toLowerCase(Locale.ROOT) + randomThreeNumbers);
                    stopper = false;
                    break;
            }
        }
    }
}
