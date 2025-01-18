package org.company;

public class CustomKey {
    private int key;

    public CustomKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return this.key % 2;
    }
}
