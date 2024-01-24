import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class SelectorTest {

    @Test
    void testMinWithValidInput() {
        // Arrange
        List<Integer> numbers = List.of(5, 2, 8, 1, 3);
        Comparator<Integer> comparator = Integer::compareTo;

        // Act
        Integer result = Selector.min(numbers, comparator);

        // Assert
        assertEquals(1, result);
    }

    @Test
    void testMinWithEmptyCollection() {
        // Arrange
        List<Integer> emptyList = Collections.emptyList();
        Comparator<Integer> comparator = Integer::compareTo;

        // Act and Assert
        assertThrows(NoSuchElementException.class, () -> Selector.min(emptyList, comparator));
    }

    @Test
    void testMinWithNullComparator() {
        // Arrange
        List<Integer> numbers = List.of(5, 2, 8, 1, 3);
        Comparator<Integer> nullComparator = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Selector.min(numbers, nullComparator));
    }

    @Test
    void testMinWithNullCollection() {
        // Arrange
        List<Integer> nullList = null;
        Comparator<Integer> comparator = Integer::compareTo;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Selector.min(nullList, comparator));
    }

    @Test
    void testMaxWithValidInput() {
        // Arrange
        List<Integer> numbers = List.of(5, 2, 8, 1, 3);
        Comparator<Integer> comparator = Integer::compareTo;

        // Act
        Integer result = Selector.max(numbers, comparator);

        // Assert
        assertEquals(8, result);
    }

    @Test
    void testMaxWithEmptyCollection() {
        // Arrange
        List<Integer> emptyList = Collections.emptyList();
        Comparator<Integer> comparator = Integer::compareTo;

        // Act and Assert
        assertThrows(NoSuchElementException.class, () -> Selector.max(emptyList, comparator));
    }

    @Test
    void testMaxWithNullComparator() {
        // Arrange
        List<Integer> numbers = List.of(5, 2, 8, 1, 3);
        Comparator<Integer> nullComparator = null;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Selector.max(numbers, nullComparator));
    }

    @Test
    void testMaxWithNullCollection() {
        // Arrange
        List<Integer> nullList = null;
        Comparator<Integer> comparator = Integer::compareTo;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> Selector.max(nullList, comparator));
    }
}