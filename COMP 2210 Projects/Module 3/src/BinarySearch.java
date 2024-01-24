import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        //Throws a NullPointerException if any parameter is null
        if (a == null || key == null || comparator == null) {
            throw new NullPointerException("Null parameter");
        } else {
            //Initialize variables
            int low = 0;
            int high = a.length - 1;
            int mid = 0;
            int firstIndex = -1;
            //Binary search
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (comparator.compare(key, a[mid]) < 0) {
                    high = mid - 1;
                } else if (comparator.compare(key, a[mid]) > 0) {
                    low = mid + 1;
                } else {
                    firstIndex = mid;
                    high = mid - 1;
                }
            }
            return firstIndex;
        }
    }

    /**
     * Returns the index of the last key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        //Throws a NullPointerException if any parameter is null
        if (a == null || key == null || comparator == null) {
            throw new NullPointerException("Null parameter");
        } else {
            //Initialize variables
            int low = 0;
            int high = a.length - 1;
            int mid = 0;
            int lastIndex = -1;
            //Binary search
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (comparator.compare(key, a[mid]) < 0) {
                    high = mid - 1;
                } else if (comparator.compare(key, a[mid]) > 0) {
                    low = mid + 1;
                } else {
                    lastIndex = mid;
                    low = mid + 1;
                }
            }
            return lastIndex;
        }
    }

}
