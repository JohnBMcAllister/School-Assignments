import java.util.Arrays;

/**
 * Defines a library of selection methods
 * on arrays of ints.
 *
 * @author   John McAllister (jbm0118@auburn.edu)
 * @author   Dean Hendrix (dh@auburn.edu)
 * @version  08/25/2023
 *
 */
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        /* TO-DO
        1. scans the int array "a"
        2. using a for loop determines the lowest value
        3. returns the lowest value of int array "a"
        4. Create an if statement that throws exceptions
         */

        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or have zero length");
        } else {
            int minimum = a[0];
            for (int i = 0; i < a.length; i++) {
                if (a[i] <= minimum) {
                    minimum = a[i];
                }
            }
            return minimum;
        }
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        /* TO-DO
        1. create an if statement that throws exceptions
        2. use for loop to scan the values of the array
        3. set maximum value to for value of array
        4. compare each value to the maximum. If value is larger than maximum set current value to maximum
         */
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or have zero length");
        } else {
            int maximum = a[0];
            for(int i = 0; i < a.length; i++) {
                if(a[i] > maximum){
                    maximum = a[i];
                }
            }
            return maximum;
        }
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmin(int[] a, int k) {
        /* TO-DO
        1. Write an if-else statement to throw illegal arguments
        2. Create a mirror array to sort data
        3. Sort Array
        4. return k-1 of sorted array
         */
        int kthMin;
        if (a == null || a.length == 0 || k < 1 || k > a.length) {
            throw new IllegalArgumentException("Invalid Argument");
        } else if (k == 1) {
            return min(a);
        } else if (k == a.length) {
            return max(a);
        } else {
            int[] b = Arrays.copyOf(a, a.length);
            Arrays.sort(b);

            int i = 0;
            int count = 1;
            while (count < k && i < b.length - 1){
                if(b[i] != b[i +1]){
                    count++;
                }
                i++;
            }
            if(count != k){
                throw new IllegalArgumentException("K value doesnt exist");
            }
            return b[i];
        }
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     */
    public static int kmax(int[] a, int k) {
        /* TO-DO
        1. Write an if-else statement to throw illegal arguments
        2. Create a mirror array to sort data
        3. Sort Array
        4. return k-1 of sorted array
         */
        int kthMax;
        if (a == null || a.length == 0 || k < 1 || k > a.length) {
            throw new IllegalArgumentException("Invalid Argument");
        } else if (k == 1) {
            return max(a);
        } else if (k == a.length) {
            return min(a);
        } else {
            int[] b = Arrays.copyOf(a, a.length);
            Arrays.sort(b);
            int i = b.length - 1;
            int count = 1;
            while(count < k && i > 0){
                if(b[i] != b[i - 1]){
                    count++;
                }
                i--;
            }
            if (count != k){
                throw new IllegalArgumentException("K value doesnt exist");
            }
            return b[i];
        }

    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     */
    public static int[] range(int[] a, int low, int high) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or have zero length");
        } else {
            int range = 0;
            for (int i = 0; i < a.length; i++){
                if (low <= a[i] && a[i] <= high){
                    range = range + 1;
                }
            }
            int[] b = new int[range];
            int count = 0;
            for(int i = 0; i < a.length; i++){
                if (low <= a[i] && a[i] <= high){
                    b[count] = a[i];
                    count = count + 1;
                }
            }
            return b;
        }
    }

    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int ceiling(int[] a, int key) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or have zero length");
        } else {
            int count1 = 0;
            for(int i = 0; i < a.length; i++){
                if (a[i] >= key){
                    count1++;
                }
            }
            int[] b = new int[count1];
            if (b.length == 0){
                throw new IllegalArgumentException("Invalid Criteria!");
            } else {
                int count2 = 0;
                for(int i = 0; i < a.length; i++) {
                    if(a[i] >= key){
                        b[count2] = a[i];
                        count2++;
                    }
                }
                return min(b);
            }
        }
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     */
    public static int floor(int[] a, int key) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or have zero length");
        } else {
            int count1 = 0;
            for(int i = 0; i < a.length; i++){
                if (a[i] <= key){
                    count1++;
                }
            }
            int[] b = new int[count1];
            if (b.length == 0){
                throw new IllegalArgumentException("Invalid Criteria!");
            } else {
                int count2 = 0;
                for(int i = 0; i < a.length; i++) {
                    if(a[i] <= key){
                        b[count2] = a[i];
                        count2++;
                    }
                }
                return max(b);
            }
        }
    }

}
