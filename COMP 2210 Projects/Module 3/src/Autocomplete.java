import java.util.Arrays;


/**
 * Autocomplete.
 */
public class Autocomplete {

    private Term[] terms;

    /**
     * Initializes a data structure from the given array of terms.
     * This method throws a NullPointerException if terms is null.
     */
    public Autocomplete(Term[] terms) {
        //Throws a NullPointerException if terms is null
        if (terms == null) {
            throw new NullPointerException("Terms is null");
        } else {
            this.terms = terms;
            Arrays.sort(this.terms);
        }
    }

    /**
     * Returns all terms that start with the given prefix, in descending order of weight.
     * This method throws a NullPointerException if prefix is null.
     */
    public Term[] allMatches(String prefix) {
        //Throws a NullPointerException if prefix is null
        if (prefix == null) {
            throw new NullPointerException("Prefix is null");
        } else {
            //Initialize variables
            Term[] matches;
            Term prefixTerm = new Term(prefix, 0);
            int firstIndex = BinarySearch.firstIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
            int lastIndex = BinarySearch.lastIndexOf(terms, prefixTerm, Term.byPrefixOrder(prefix.length()));
            //Check if there are matches
            if (firstIndex == -1 || lastIndex == -1) {
                matches = new Term[0];
            } else {
                matches = new Term[lastIndex - firstIndex + 1];
                for (int i = 0; i < matches.length; i++) {
                    matches[i] = terms[firstIndex + i];
                }
                Arrays.sort(matches, Term.byDescendingWeightOrder());
            }
            return matches;
        }
    }

}

