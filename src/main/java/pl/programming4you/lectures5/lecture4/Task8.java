package pl.programming4you.lectures5.lecture4;

import java.util.ArrayList;
import java.util.List;

public class Task8 {
    public static boolean haveSameElements(List<String> list, String[] array) {
        for (int i = 0; i < Math.min(list.size(), array.length); i++) {
            if (!list.get(i).equals(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("a", "b", "c", "d"));
        String[] array = {"a", "b"};
        System.out.println(haveSameElements(list, array));

    }
}
