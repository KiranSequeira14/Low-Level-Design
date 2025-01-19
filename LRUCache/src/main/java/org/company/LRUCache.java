package org.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    Map<K, CacheNode<K, V>> cache;
    CacheNode<K, V> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new CacheNode<>();
        tail = new CacheNode<>();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public V get(K k) {
        if (cache.containsKey(k)) {
            CacheNode<K, V> cur = cache.get(k);
            delete(cur);
            insert(cur);
            return cur.getV();
        } else
            return null;
    }

    public void put(K k, V v) {
        if (cache.containsKey(k)) {
            delete(cache.get(k));
        } else if (cache.size() == this.capacity) {
            delete(tail.getPrev());
        }
        insert(new CacheNode<>(k, v));
    }

    private void insert(CacheNode<K, V> node) {
        //Insert at the beginning
        head.getNext().setPrev(node);
        node.setNext(head.getNext());
        node.setPrev(head);
        head.setNext(node);

        cache.put(node.getK(), node);
    }

    private void delete(CacheNode<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        node.setNext(null);
        node.setPrev(null);

        cache.remove(node.getK());
    }
}
