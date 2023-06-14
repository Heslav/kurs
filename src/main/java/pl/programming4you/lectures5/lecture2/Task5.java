package pl.programming4you.lectures5.lecture2;

public class Task5 {
    static void printZiomek(int upperBound) {
        for (int i = 1; i <= upperBound; i++) {
            if (i % 3 == 0) {
                continue;
            }
            System.out.print(i + " ");
            if (i % 4 == 0) {
                System.out.print("Zio");
            }
            if (i % 5 == 0) {
                System.out.print("mek");
            }
            System.out.println();
        }
    }
}
