/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class MyHashMap {
    private static final int INITIAL_CAPACITY = 16;
    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int getBucketIndex(String key) {
        return Math.abs(key.hashCode() % INITIAL_CAPACITY);
    }

    public void put(String key, String value) {
        int index = getBucketIndex(key);
        Entry newEntry = new Entry(key, value);
        if (buckets[index] == null) {
            buckets[index] = newEntry;
        } else {
            // Handle collision by chaining (LinkedList implementation)
            // if bucket already occupied
            Entry current = buckets[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newEntry;
        }
    }
    
    public Entry get(String key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null; // Key not found
    }

}
