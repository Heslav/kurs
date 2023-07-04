package pl.programming4you.lectures5.lecture4;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.programming4you.lectures5.lecture1.Task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Task8Test {
    @Test
    @DisplayName("Should return true if list and array have the same element on the same index")
    public void testHaveSameElementsTrue() {
        List<String> list = new ArrayList<>(List.of("1", "2", "3", "4"));
        String[] array = {"1", "2"};
        assertTrue(Task8.haveSameElements(list, array));
    }

    @Test
    @DisplayName("Should return false if list and array don't have same element on the same index")
    public void testHaveSameElementsFalse() {
        List<String> list = new ArrayList<>(List.of("1", "2", "3", "4"));
        String[] array = {"2", "1"};
        assertFalse(Task8.haveSameElements(list, array));
    }

    @Test
    @DisplayName("Should return false if list and array don't have same element on the same index")
    public void testHaveSameElementsArrayLongerThanListFalse() {
        List<String> list = new ArrayList<>(List.of("1", "2"));
        String[] array = {"2", "1", "3", "4"};
        assertFalse(Task8.haveSameElements(list, array));
    }

    @Test
    @DisplayName("Should return false if list and array don't have same element on the same index")
    public void testHaveSameElementsArrayLongerThanListTrue() {
        List<String> list = new ArrayList<>(List.of("1", "2"));
        String[] array = {"1", "2", "3", "4"};
        assertTrue(Task8.haveSameElements(list, array));
    }

    @Test
    @DisplayName("Should throw an exception if list or array is null")
    public void shouldThrowIllegalArgumentExceptionForNull() {
        assertThrows(IllegalArgumentException.class, () -> Task8.haveSameElements(null, null));
    }

    @Test
    @DisplayName("Should throw an exception if list or array is empty")
    public void shouldThrowIllegalArgumentExceptionForEmpty() {
        List<String> list = new ArrayList<>();
        String[] array = {};
        assertThrows(IllegalArgumentException.class, () -> Task8.haveSameElements(list, array));
    }
}