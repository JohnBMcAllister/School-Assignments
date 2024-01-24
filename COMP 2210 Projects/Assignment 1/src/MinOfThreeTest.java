import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinOfThreeTest {

    @Test
    public void min1() {
        //integers to test
        int a = 2;
        int b = 2;
        int c = 3;

        //Test and expected outcome
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    public void min2() {
        //integers to test
        int a = 3;
        int b = 1;
        int c = 2;

        //Test and expected outcome
        int expected = 1;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }
}