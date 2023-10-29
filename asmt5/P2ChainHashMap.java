package asmt5;

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

import java.util.ArrayList;
import java.util.Random;

/*
 * Map implementation using hash table with separate chaining.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class P2ChainHashMap<K,V> extends AbstractMap<K,V> {
    private int n = 0;                 // number of entries in the map
    private int capacity;              // length of the table
    private int prime;                   // prime factor
    private long scale1, shift1;           // the shift and scaling factors
    private long scale2, shift2;           // the shift and scaling factors for power-of-two hashing

    // a fixed capacity array of UnsortedTableMap that serve as buckets
    private UnsortedTableMap<K,V>[] table;   // initialized within createTable

    // provide same constructors as base class
    /** Creates a hash table with capacity 11 and prime factor 109345121. */
    public P2ChainHashMap() {
        capacity = 11;
        prime = 109345121;
        Random rand = new Random(1234);  // Random seed: 1234
        scale1 = rand.nextInt(prime-1) + 1;
        shift1 = rand.nextInt(prime);
    }

    /** Creates a hash table with the given capacity and hash parameters. */
    public P2ChainHashMap(int cap, int p) {
        capacity = cap;
        prime = p;
        /** Creates an empty table having length equal to current capacity. */
        table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
        scale1 = 233177;
        shift1 = 141604;
        scale2 = 64667;
        shift2 = 104206;

    }

    // Public methods
    /**
     * Counts the number of entries in the map.
     * @return number of entries in the map
     */
    @Override
    public int size() { return n; }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K,V>> entrySet() {
        ArrayList<Entry<K,V>> buffer = new ArrayList<>();
        for (int h=0; h < capacity; h++)
            if (table[h] != null)
                for (Entry<K,V> entry : table[h].entrySet())
                    buffer.add(entry);
        return buffer;
    }

    /**
     * Associates the given value with the given key. If an entry with
     * the key was already in the map, this replaces the previous value
     * with the new one and returns the old value. Otherwise, a new
     * entry is added and null is returned.
     * @param key    key with which the specified value is to be associated
     * @param value  value to be associated with the specified key
     * @return the previous value associated with the key (or null, if no such entry)
     */
    public V put(K key, V value) {
        int[] hashes = hashValue(key);
        int h = hashes[0];  // the hash value of the selected bucket
        UnsortedTableMap<K,V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();

        int oldSize = bucket.size();
        V answer = bucket.put(key,value);
        n += (bucket.size() - oldSize);   // size may have increased

        return answer;  // previous value associated with key (or null, if no such entry)
    }

    /**
     * Returns the value associated with the specified key, or null if no such entry exists.
     * @param key  the key whose associated value is to be returned
     * @return the associated value, or null if no such entry exists
     */
    public V get(K key) {
        int[] hashes = hashValue(key);
        int h = hashes[0];  // the hash value of the selected bucket
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket != null) {
            return bucket.get(key);
        }
        return null;  // key not found
    }

    /**
     * Removes the entry with the specified key, if present, and returns
     * its associated value. Otherwise does nothing and returns null.
     * @param key  the key whose entry is to be removed from the map
     * @return the previous value associated with the removed key, or null if no such entry exists
     */
    public V remove(K key) {
        int[] hashes = hashValue(key);
        int h = hashes[0];  // the hash value of the selected bucket
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket != null) {
            int oldSize = bucket.size();
            V removedValue = bucket.remove(key);
            n -= (oldSize - bucket.size());  // update the size

            return removedValue;  // previous value associated with the removed key (or null if not found)
        }
        return null;  // key not found
    }

    // Private utilities
    /**
     * Returns the hash values from power-of-two-choices hashing.
     * Compare buckets of hash values:
     * [(scale1*k + shift1) mod p] mod N, [(scale2*k + shift2) mod p] mod N
     *
     * @return an array of hash values: hashVals[0]: selected hash;
     * hashVals[1], hashVals[2}: two candidate hash values
     */
    private int[] hashValue(K key) {
        int[] hashVals = new int[3];
        int k = key.hashCode();
        hashVals[0] = (int) (((scale1 * k + shift1) % prime) % capacity);
        hashVals[1] = (int) (((scale2 * k + shift2) % prime) % capacity);
        hashVals[2] = (int) (k % capacity);
        return hashVals;
    }

    private static String generateRandomString(int length, Random random) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int testNum = 10000;  // Number of records
        P2ChainHashMap<Integer, String> testMap = new P2ChainHashMap<>(14000, 239489);

        /* Insert entries of form (student_number, student_name), count and print number of collisions */
        int nameLen = 4;
        int minKey = 30000;
        long collisions = 0;

        Random random = new Random(1234);



        for (int i = 0; i < testNum; i++) {
            int key = minKey + i;
            String value = generateRandomString(nameLen, random);
            String previousValue = testMap.put(key, value);
            if (previousValue != null) {
                collisions++;
            }
        }

       

        System.out.println("Number of collisions: " + collisions);
                

        for (int i = minKey; i < minKey + testNum; i++) {
            if ((i / 1000) % 10 == 5) {
                // If the key matches the pattern x5xxx, remove it
                testMap.remove(i);

            }
        }
        System.out.println("Number of remaining records: " + testMap.size());
    }
}


