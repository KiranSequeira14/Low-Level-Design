package org.company;

public class Main {
    public static void main(String[] args) {
        HashMapImpl<CustomKey, Integer> hashMap = new HashMapImpl<>();
        CustomKey key1 = new CustomKey(23);
        CustomKey key2 = new CustomKey(433);
//        System.out.println(key2.equals(key1));
        hashMap.put(key1, 23);
        hashMap.put(key2, 433);
        hashMap.put(new CustomKey(64), 64);
        CustomKey key3 = new CustomKey(346);
        hashMap.put(key3, 346);
        hashMap.put(new CustomKey(28), 28);
        CustomKey key5 = new CustomKey(9003);
        hashMap.put(key5, 9003);
        System.out.println(hashMap.get(key1));

        System.out.println(hashMap.remove(key5));
    }
}
