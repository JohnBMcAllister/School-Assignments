import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 *
 */
public class Term implements Comparable<Term> {
    private String query;
    private long weight;

    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) {
        if (query == null) {
            throw new NullPointerException("Query is null");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Weight is negative");
        }
        this.query = query;
        this.weight = weight;
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                if (o1.weight > o2.weight) {
                    return -1;
                } else if (o1.weight < o2.weight) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) {
        //Throws an IllegalArgumentException if length is less than or equal to zero
        if (length <= 0) {
            throw new IllegalArgumentException("Length is less than or equal to zero");
        } else {
            //Returns a new Comparator object
            return new Comparator<Term>() {
                @Override
                public int compare(Term o1, Term o2) {
                    //Compares the two terms in acsending lexicographic order of query
                    //but using only the first length characters of query
                    if (o1.query.length() < length && o2.query.length() < length) {
                        return o1.query.compareTo(o2.query);
                    } else if (o1.query.length() < length) {
                        return o1.query.compareTo(o2.query.substring(0, length));
                    } else if (o2.query.length() < length) {
                        return o1.query.substring(0, length).compareTo(o2.query);
                    } else {
                        return o1.query.substring(0, length).compareTo(o2.query.substring(0, length));
                    }
                }
            };
        }
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
        return this.query.compareTo(other.query);
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
        return this.query + "\t" + this.weight;
    }

}

