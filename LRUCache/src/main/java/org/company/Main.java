package org.company;

public class Main {
    public static void main(String[] args) {
        //TO do:
        //Implement the LRUCache class:
        //
        //LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        //int get(int key) Return the value of the key if the key exists, otherwise return -1.
        //void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
        //The functions get and put must each run in O(1) average time complexity.

        String[] actions = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] values = {{2}, {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};

        LRUCache<Integer, Integer> lruCache = null;

        for (int i = 0; i < actions.length; i++) {
            if (actions[i].equals("LRUCache")) {
                lruCache = new LRUCache<>(values[i][0]);
                System.out.println("null");
            } else if (actions[i].equals("put")) {
                lruCache.put(values[i][0], values[i][1]);
                System.out.println("null");
            } else {
                System.out.println(lruCache.get(values[i][0]));
            }
        }
    }
}