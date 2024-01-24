import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author YOUR NAME (you@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
    public boolean add(T element) {
        // Neither null or duplicate values are allowed
        if (element == null || contains(element)) {
            return false;
        }
        Node C = front;
        Node N = new Node(element);

        if(isEmpty()) {
            front = N;
            rear = N;
            size++;
            return true;
        } else if(front.element.compareTo(element) > 0) {
            N.next = front;
            front.prev = N;
            front = N;
            size++;
            return true;
        } else if(element.compareTo(rear.element) > 0) {
            rear.next = N;
            N.prev = rear;
            rear = N;
            size++;
            return true;
        } else {
            Node a = prevNode(element);
            a.next.prev = N;
            N.next = a.next;
            a.next = N;
            N.prev = a;
            size++;
            return true;
        }
    }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
    public boolean remove(T element) {
        //set doesnt contain element returns false
        if (!contains(element)) {
            return false;
        }

        //if size = 1 set to null and return true
        if (size == 1) {
            front = null;
            rear = null;
            size--;
            return true;
        }

        Node n = new Node(element);
        Node p = front;
        while (!p.element.equals(element)) {
            p = p.next;
        }
        if (p == front){
            p.next.prev = null;
            front = p.next;
            size--;
            return true;
        }
        if (p == rear) {
            rear = p.prev;
            rear.next = null;
            rear.prev = p.prev.prev;
            size--;
            return true;
        }
        p.element = null;
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size--;
        return true;
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */
    public boolean contains(T element) {
        Node x = front;
        while (x != null) {
            if (x.element.compareTo(element) == 0) {
                return true;
            }
            x = x.next;
        }
        return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(Set<T> s) {
        if (s.size() == size && complement(s).size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(LinkedSet<T> s) {
        if (s.size() == size && complement(s).size() == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(Set<T> s){
        LinkedSet<T> union = new LinkedSet<T>();
        Node x = front;
        while (x != null) {
            union.add(x.element);
            x = x.next;
        }
        if (s == null) {
            return union;
        }
        Iterator<T> itr = s.iterator();
        while (itr.hasNext()) {
            union.add(itr.next());
        }
        return union;

    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(LinkedSet<T> s){
        LinkedSet<T> union = new LinkedSet<T>();
        Node x = front;
        Node n = s.front;
        if (s.isEmpty()) {
            while (x != null) {
                union.add(x.element);
                x = x.next;
            }
            return union;
        }
        if (this.isEmpty()){
            while (n != null) {
                union.add(n.element);
                n = n.next;
            }
            return union;
        }
        while (x != null && n != null) {
            if (x.element.compareTo(n.element) < 0) {
                union.add(x.element);
                x = x.next;
            } else if (x.element.compareTo(n.element) > 0) {
                union.add(n.element);
                n = n.next;
            } else {
                union.add(x.element);
                x = x.next;
                n = n.next;
            }
        }
        return union;
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
    public Set<T> intersection(Set<T> s) {
        LinkedSet<T> intersection = new LinkedSet<T>();
        if (s == null) {
            return intersection;
        }
        Node x = front;
        while (x != null) {
            if (s.contains(x.element)) {
                intersection.add(x.element);
            }
            x = x.next;
        }
        return intersection;
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */
    public Set<T> intersection(LinkedSet<T> s) {
        LinkedSet<T> intersection = new LinkedSet<T>();
        if (s == null) {
            return intersection;
        }
        Node x = front;
        Node n = s.front;
        while (x != null && n != null) {
            if (x.element.compareTo(n.element) < 0) {
                x = x.next;
            } else if (x.element.compareTo(n.element) > 0) {
                n = n.next;
            } else {
                intersection.add(x.element);
                x = x.next;
                n = n.next;
            }
        }
        return intersection;
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
    public Set<T> complement(Set<T> s) {
        Node t = front;
        LinkedSet<T> complement = new LinkedSet<T>();
        if (isEmpty()) {
            return complement;
        }
        if (s == null) {
            while (t != null) {
                complement.add(t.element);
                t = t.next;
            }
            return complement;
        }
        while (t != null) {
            if (!s.contains(t.element)) {
                complement.add(t.element);
            }
            t = t.next;
        }
        return complement;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
    public Set<T> complement(LinkedSet<T> s) {
        LinkedSet<T> complement = new LinkedSet<T>();
        Node x = front;
        Node n = s.front;
        if (s.isEmpty()) {
            while (x != null) {
                complement.add(x.element);
                x = x.next;
            }
            return complement;
        }
        return complement;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> iterator() {
        //Returns an iterator over the elements in this LinkedSet.
        // Elements are returned in ascending natural order.
        return new LinkedSetIterator();
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() {
        return new DescendingIterator();
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() {
        return null;
    }



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.
    private Node prevNode(T element) {
        Node x = front;
        while (x == null) {
            if (x.element.compareTo(element) > 0) {
                return x.prev;
            }
            x = x.next;
        }
        return x;
    }



    private boolean LinkedSetAdd(T element) {
        if(element == null) {
            return false;
        }
        Node current = front;
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            size++;
            return true;
        } else if (front.element.compareTo(element) > 0) {
            newNode.next = front;
            front.prev = front;
            front = newNode;
            size++;
            return true;
        } else if (front.element.compareTo(element) < 0) {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
            size++;
            return true;
        }
        return false;
    }

    private class LinkedSetIterator implements Iterator<T> {
        private Node current = front;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = current.element;
            current = current.next;
            return result;
        }
    }

    private class DescendingIterator implements Iterator<T> {
        private Node current = rear;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = current.element;
            current = current.prev;
            return result;
        }
    }

    ////////////////////
    // Nested classes //
    ////////////////////

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }



}
