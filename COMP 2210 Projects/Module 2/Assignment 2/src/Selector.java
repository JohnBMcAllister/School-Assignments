import java.sql.Array;
import java.util.*;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  JB McAllister (jbm0118@auburn.edu)
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
     * Returns the minimum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the minimum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T min(Collection<T> coll, Comparator<T> comp) {
        //Throws IllegalArgumentExceptions
        if(comp == null || coll == null) {
            throw new IllegalArgumentException("The Comparator or Collection cannot be null");

            //Throws NoSuchElementException
        } else if (coll.isEmpty()) {
            throw new NoSuchElementException("The Collection is empty");
            //Returns min value
        } else {
            T min = null;
            for (T item : coll){
                if (min == null || comp.compare(item, min) < 0) {
                    //checks to see if min is null or item is smaller than updates min.
                    min = item;
                }
            }
            return min;
        }
    }


    /**
     * Selects the maximum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the maximum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T max(Collection<T> coll, Comparator<T> comp) {
        //Throws IllegalArgumentExceptions
        if(comp == null || coll == null) {
            throw new IllegalArgumentException("The Comparator or Collection cannot be null");

            //Throws NoSuchElementException
        } else if (coll.isEmpty()) {
            throw new NoSuchElementException("The Collection is empty");
            //Returns max value
        } else {
            T max = null;
            for (T item : coll){
                if (max == null || comp.compare(item, max) > 0) {
                    //checks to see if min is null or item is smaller than updates min.
                    max = item;
                }
            }
            return max;
        }
    }


    /**
     * Selects the kth minimum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth minimum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth minimum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
        //Throws IllegalArgumentExceptions
        if(comp == null || coll == null) {
            throw new IllegalArgumentException("The Comparator or Collection cannot be null");

            //Throws NoSuchElementException
        } else if (coll.isEmpty() || k < 1 || k > coll.size()) {
            throw new NoSuchElementException("The Collection is empty");
            //Returns min value
        } else {
            ArrayList<T> B = new ArrayList<T>(coll);

            java.util.Collections.sort(B, comp);

            int i = 0;
            int count = 1;
            while (count < k && i < B.size() - 1) {
                if(B.get(i) != B.get(i + 1)){
                    count++;
                }
                i++;
            }
            if(count != k){
                throw new NoSuchElementException("K value does not exist");
            }
            return B.get(i);
        }
    }


    /**
     * Selects the kth maximum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth maximum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth maximum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
        //Throws IllegalArgumentExceptions
        if(comp == null || coll == null) {
            throw new IllegalArgumentException("The Comparator or Collection cannot be null");

            //Throws NoSuchElementException
        } else if (coll.isEmpty() || k < 1 || k > coll.size()) {
            throw new NoSuchElementException("No Such Element");
            //Returns max value
        } else {
            // copies collection then sort
            ArrayList<T> B = new ArrayList<T>(coll);

            java.util.Collections.sort(B, comp);

            int i = B.size() - 1;
            int count = 1;
            while (count < k && i > 0) {
                if(B.get(i) != B.get(i - 1)){
                    count++;
                }
                i--;
            }
            if(count != k){
                throw new NoSuchElementException("K value does not exist");
            }
            return B.get(i);
        }
    }


    /**
     * Returns a new Collection containing all the values in the Collection coll
     * that are greater than or equal to low and less than or equal to high, as
     * defined by the Comparator comp. The returned collection must contain only
     * these values and no others. The values low and high themselves do not have
     * to be in coll. Any duplicate values that are in coll must also be in the
     * returned Collection. If no values in coll fall into the specified range or
     * if coll is empty, this method throws a NoSuchElementException. If either
     * coll or comp is null, this method throws an IllegalArgumentException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the range values are selected
     * @param low     the lower bound of the range
     * @param high    the upper bound of the range
     * @param comp    the Comparator that defines the total order on T
     * @return        a Collection of values between low and high
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                          Comparator<T> comp) {
        //Throws IllegalArgumentExceptions
        if (comp == null || coll == null) {
            throw new IllegalArgumentException("The Comparator or Collection cannot be null");

            //Throws NoSuchElementException
        } else if (coll.isEmpty()) {
            throw new NoSuchElementException("The Collection is empty");
            //Returns max value
        } else {
            int range = 0;
            ArrayList<T> B = new ArrayList<T>();
            Iterator<T> i = coll.iterator();

            while (i.hasNext()) {
                T element = i.next();
                if (comp.compare(element, low) >= 0 && comp.compare(element, high) <= 0) {
                    B.add(element);
                }
            }
            if (B.size() == 0){
                throw new NoSuchElementException("Range is empty");
            }
            return B;
        }
    }




        /**
         * Returns the smallest value in the Collection coll that is greater than
         * or equal to key, as defined by the Comparator comp. The value of key
         * does not have to be in coll. If coll or comp is null, this method throws
         * an IllegalArgumentException. If coll is empty or if there is no
         * qualifying value, this method throws a NoSuchElementException. This
         * method will not change coll in any way.
         *
         * @param coll    the Collection from which the ceiling value is selected
         * @param key     the reference value
         * @param comp    the Comparator that defines the total order on T
         * @return        the ceiling value of key in coll
         * @throws        IllegalArgumentException as per above
         * @throws        NoSuchElementException as per above
         */
        public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
            if (comp == null || coll == null) {
                throw new IllegalArgumentException("The Comparator or Collection cannot be null");


            } else if (coll.isEmpty()) {
                throw new NoSuchElementException("The Collection is empty");

            } else {
                ArrayList B = new ArrayList();
                Iterator<T> i = coll.iterator();
                T ceiling = i.next();
                int index = 0;

                if (i.hasNext()){
                    for (T element: coll) {
                        if (comp.compare(element, ceiling) > 0) {
                            ceiling = element;
                        }
                    }
                }
                for (T element : coll) {
                    if (comp.compare(element, key) >= 0 && comp.compare(element, ceiling) <= 0) {
                        ceiling = element;
                        index++;
                    }
                }

                if (index == 0) {
                    throw new NoSuchElementException("Invalid Criteria");
                }
                return ceiling;
            }
        }


        /**
         * Returns the largest value in the Collection coll that is less than
         * or equal to key, as defined by the Comparator comp. The value of key
         * does not have to be in coll. If coll or comp is null, this method throws
         * an IllegalArgumentException. If coll is empty or if there is no
         * qualifying value, this method throws a NoSuchElementException. This
         * method will not change coll in any way.
         *
         * @param coll    the Collection from which the floor value is selected
         * @param key     the reference value
         * @param comp    the Comparator that defines the total order on T
         * @return        the floor value of key in coll
         * @throws        IllegalArgumentException as per above
         * @throws        NoSuchElementException as per above
         */
        public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
            if (comp == null || coll == null) {
                throw new IllegalArgumentException("The Comparator or Collection cannot be null");


            } else if (coll.isEmpty()) {
                throw new NoSuchElementException("The Collection is empty");

            } else {
                ArrayList B = new ArrayList();
                Iterator<T> i = coll.iterator();
                T floor = i.next();
                int index = 0;

                if (i.hasNext()){
                    for (T element: coll) {
                        if (comp.compare(element, floor) < 0) {
                            floor = element;
                        }
                    }
                }
                for (T element : coll) {
                    if (comp.compare(element, key) <= 0 && comp.compare(element, floor) >= 0) {
                        floor = element;
                        index++;
                    }
                }

                if (index == 0) {
                    throw new NoSuchElementException("Invalid Criteria");
                }
                return floor;
            }
        }

}
