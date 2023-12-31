package asmt7.pqueue;

import java.util.ArrayList;
import java.util.Arrays;

public class HeapPQAlgos<K, V> extends HeapPriorityQueue<K, V> {
    HeapPQAlgos(K[] keys, V[] values) {
        super(keys, values);
    }

    /*
     Given n entries stored in the heap, return entries with the first k smallest keys.
     */
    public ArrayList<Entry<K, V>> kSmallest(int k) {
        ArrayList<Entry<K, V>> result = new ArrayList<>();

        for (int i = 0; i < Math.min(k, size()); i++) {
            result.add(removeMin());
        }
        return result;

    }

    /*
     Find all entries having a key less than or equal to k.
     */
    public ArrayList<Entry<K, V>> subPQ(int k) {

        ArrayList<Entry<K, V>> result = new ArrayList<>();  
        for (Entry<K, V> entry : heap) {
            if ((Integer)entry.getKey() <= k) {
                result.add(entry);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Integer[] keys = {2, 5, 4, 15, 9, 7, 6, 16, 25, 14, 12, 11, 8, 20, 10};
        String[] values = {"B", "A", "C", "K", "F", "Q", "Z", "X", "J", "E", "H", "S", "W", "B", "L"};
        HeapPQAlgos<Integer, String> testPQ = new HeapPQAlgos<>(keys, values);

        // Question 1
        int k = 3;
        ArrayList<Entry<Integer, String>> smallEntries = testPQ.kSmallest(k);
        System.out.println("Keys of " + k + " smallest entries: ");
        for (Entry<Integer, String> e : smallEntries)
            System.out.println(e.getKey());
        
        // Question 2
        k = 7;
        ArrayList<Entry<Integer, String>> subEntries = testPQ.subPQ(k);
        System.out.println("Keys of entries <= " + k + ": ");
        for (Entry<Integer, String> e : subEntries)
            System.out.println(e.getKey());
    }
}
