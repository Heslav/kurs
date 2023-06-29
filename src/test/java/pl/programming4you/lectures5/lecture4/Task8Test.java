package pl.programming4you.lectures5.lecture4;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task8Test {
    @Test
    @DisplayName("Should return true if list and array have the same element on the same index")
    public void testHaveSameElementsTrue() {
        List<String> list = new ArrayList<>(List.of("1", "2", "3", "4"));
        String[] array1 = {"1", "2"};
        assertTrue(Task8.haveSameElements(list, array1));
    }

    @Test
    @DisplayName("Should return false if list and array don't have same element on the same index")
    public void testHaveSameElementsFalse() {
        List<String> list = new ArrayList<>(List.of("1", "2", "3", "4"));
        String[] array2 = {"2", "1"};
        assertFalse(Task8.haveSameElements(list, array2));
    }
}