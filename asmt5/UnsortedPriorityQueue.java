package asmt5;

import java.util.Comparator;
import java.util.LinkedList;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * An implementation of a priority queue with an unsorted list.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

public class UnsortedPriorityQueue<K,V> implements PriorityQueue<K,V> {
    /**
     * A concrete implementation of the Entry interface to be used within
     * a PriorityQueue implementation.
     */
    protected class PQEntry<K,V> implements Entry<K,V> {
        private K k;  // key
        private V v;  // value

        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        // methods of the Entry interface
        public K getKey() { return k; }
        public V getValue() { return v; }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) { k = key; }
        protected void setValue(V value) { v = value; }
    }

    /** The comparator defining the ordering of keys in the priority queue. */
    private Comparator<K> comp;

    /** Primary collection of priority queue entries.
     * Use a doubly linked list.
     */
    private LinkedList<Entry<K,V>> list = new LinkedList<>();

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     * @param c comparator defining the order of keys in the priority queue
     */
    public UnsortedPriorityQueue(Comparator<K> c) { comp = c; }

    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public UnsortedPriorityQueue() { this(new DefaultComparator<K>()); }

    /** Method for comparing two entries according to key */
    private int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /** Determines whether a key is valid. */
    private boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key,key) == 0);  // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Returns the number of items in the priority queue.
     * @return number of items
     */
    public int size() { return list.size(); }

    /**
     * Tests whether the priority queue is empty.
     * @return true if the priority queue is empty, false otherwise
     */
    public boolean isEmpty() { return size() == 0; }

    /**
     * Inserts a key-value pair and returns the entry created.
     * @param key     the key of the new entry
     * @param value   the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this queue
     */
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);    // auxiliary key-checking method (could throw exception)
        Entry<K,V> newest = new PQEntry<>(key, value);
        list.addLast(newest);  // append specified element to the end of this list
        return newest;
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     * @return entry having a minimal key (or null if empty)
     */
    public Entry<K,V> min() {
        if(list.isEmpty()) 
        {
            return null;
        }

        Entry<K,V> minEntry = list.getFirst();
        for (Entry<K,V> entry :list)
        {
            if (compare(entry,minEntry) < 0)
            minEntry = entry;
        }

        return minEntry;

    }

    /**
     * Removes and returns an entry with minimal key.
     * @return the removed entry (or null if empty)
     */
    public Entry<K,V> removeMin() {
        if (list.isEmpty()) {
            return null;
        }

        Entry<K, V> minEntry = min();
        list.remove(minEntry);
        return minEntry;

    }

    /**
     * Tests operations of this priority queue.
     */
    public static void main(String[] args) {
        asmt5.UnsortedPriorityQueue<Integer, String> testPQ = new asmt5.UnsortedPriorityQueue<>();
        testPQ.insert(5, "John");
        testPQ.insert(1, "Amy");
        testPQ.removeMin();
        testPQ.insert(7, "David");
        testPQ.insert(6, "Helen");
        testPQ.removeMin();
        testPQ.insert(10, "Zack");
        while (!testPQ.isEmpty()) {
            System.out.println(testPQ.removeMin().getValue());
        }
    }
}

