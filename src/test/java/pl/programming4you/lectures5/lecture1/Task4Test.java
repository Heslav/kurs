package pl.programming4you.lectures5.lecture1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task4Test {

    @Test
    public void shouldReturnMessageShort() {
        String shortString = "Lol";
        String expectedMessage = "Your string is not too long";
        assertEquals(expectedMessage, Task4.checkStringLength(shortString));
    }

    @Test
    public void shouldReturnMessageLong() {
        String longString = "Let's go Brandon";
        String expectedMessage = "Your string is quite long";
        assertEquals(expectedMessage, Task4.checkStringLength(longString));
    }
}