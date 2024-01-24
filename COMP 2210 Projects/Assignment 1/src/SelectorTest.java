import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SelectorTest {

    @Test
    void minTest1() {
        int[] a = {2, 4, 8, 1, 10};
        int expected = 1;
        int actual = Selector.min(a);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void minTest2() {
        int[] a = {6, 2, 2, 1, 10};
        int expected = 1;
        int actual = Selector.min(a);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minTest3() {
        int[] a = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.min(a);
        });
    }

    @Test
    void minTest4() {
        int[] a = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.min(a);
        });
    }

    @Test
    void maxTest1() {
        int[] a = {2, 4, 8, 1, 10};
        int expected = 10;
        int actual = Selector.max(a);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void maxTest2() {
        int[] a = {6, 2, 22, 1, 10};
        int expected = 22;
        int actual = Selector.max(a);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void maxTest3() {
        int[] a = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.max(a);
        });
    }

    @Test
    void maxTest4() {
        int[] a = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.max(a);
        });
    }

    @Test
    void kthMinTest1() {
        int[] a = {2, 4, 8, 1, 10};
        int k = 3;
        int expected = 4;
        int actual = Selector.kmin(a, 3);
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void kthMinTest2() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 4;
        int expected = 4;
        int actual = Selector.kmin(a,4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void kthMinTest3() {
        int[] a = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.kmin(a, 5);
        });
    }

    @Test
    void kthMinTest4() {
        int[] a = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.kmin(a, 5);
        });
    }

    @Test
    void kthMinTest5() {
        int[] a = {1, 3, 5};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.kmin(a, 0);
        });
    }

    @Test
    void kthMinTest6() {
        int[] a = {1, 3, 5};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Selector.kmin(a, 4);
        });
    }

    @Test
    void kthMaxTest1() {
        int[] a = {1, 2, 3, 4, 5};
        int k = 2;
        int expected = 4;
        int actual = Selector.kmax(a,2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void kthMaxTest2() {
        int[] a = {1, 3, 5, 7, 9};
        int k = 1;
        int expected = 9;
        int actual = Selector.kmax(a,1);
        Assertions.assertEquals(expected, actual);
    }
}