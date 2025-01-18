package org.company;

import java.util.ArrayList;

public class HashMapImpl<K, V> {
    int size;
    int maxCapacity;
    ArrayList<Node<K, V>> buckets;
    private Node<K, V> node;

    public HashMapImpl() {
        size = 0;
        buckets = new ArrayList<>();
        maxCapacity = 10;

        for (int i = 0; i < maxCapacity; i++) {
            buckets.add(null);
        }
    }

    public V get(K key) {
        int bucketIdx = this.getBucketIdx(key);
        Node<K, V> node = buckets.get(bucketIdx);
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public void put(K key, V value) {
        int bucketIdx = this.getBucketIdx(key);
        Node<K, V> node = buckets.get(bucketIdx);

        while (node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }
        node = buckets.get(bucketIdx);
        this.size++;
        Node<K, V> curNode = new Node<>(key, value);
        curNode.setNext(node);
        buckets.set(bucketIdx, curNode);

        if (((1.0 * this.size) / this.maxCapacity) >= 0.75) {
            ArrayList<Node<K, V>> temp = buckets;
            buckets = new ArrayList<>();
            this.maxCapacity *= 2;
            this.size = 0;
            for (int i = 0; i < this.maxCapacity; i++) {
                buckets.add(null);
            }

            for (Node<K, V> oldNode : temp) {
                while (oldNode != null) {
                    this.put(oldNode.getKey(), oldNode.getValue());
                    oldNode = oldNode.getNext();
                }
            }
        }
    }

    public V remove(K key) {
        int bucketIdx = this.getBucketIdx(key);
        Node<K, V> node = buckets.get(bucketIdx);
        Node<K, V> prev = null;

        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    this.buckets.set(bucketIdx, node.getNext());
                } else {
                    prev.setNext(node.getNext());
                }
                this.size--;
                return node.getValue();
            }
            prev = node;
            node = node.getNext();
        }
        return null;
    }

    public int getBucketIdx(K key) {
        return Math.abs(key.hashCode() % maxCapacity);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
