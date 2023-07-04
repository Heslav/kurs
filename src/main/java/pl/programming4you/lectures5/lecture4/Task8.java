package pl.programming4you.lectures5.lecture4;

import java.util.List;

public class Task8 {
    public static boolean haveSameElements(List<String> list, String[] array) {
        if (list == null || list.isEmpty() || array == null || array.length == 0) {
            throw new IllegalArgumentException("List cannot be empty or null");
        }
        for (int i = 0; i < Math.min(list.size(), array.length); i++) {
            if (list.get(i).equals(array[i])) {
                return true;
            }
        }
        return false;
    }
}
