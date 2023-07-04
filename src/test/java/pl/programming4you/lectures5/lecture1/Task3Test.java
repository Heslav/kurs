package pl.programming4you.lectures5.lecture1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task3Test {
    @Test
    public void testAddition() {
        var task = new Task3();
        assertEquals("50 plus 25 is 75", task.addition(50, 25));
    }

    @Test
    public void testSubtraction() {
        var task = new Task3();
        assertEquals("50 minus 25 is 25", task.subtraction(50, 25));
    }

    @Test
    public void testMultiplication() {
        var task = new Task3();
        assertEquals("50 times 25 is 1250", task.multiplication(50, 25));
    }

    @Test
    public void testDivision() {
        var task = new Task3();
        assertEquals("50 divided by 25 is 2", task.division(50, 25));
    }
}

