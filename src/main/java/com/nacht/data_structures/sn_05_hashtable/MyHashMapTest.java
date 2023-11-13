package com.nacht.data_structures.sn_05_hashtable;

/**
 * @author Nacht
 * Created on 2023/11/13 21:36
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>(3);
        map.put("fuck", "the world1");
        map.put("fuck1", "the world2");
        map.put("fuck2", "the world3");
        map.put("fuck2", "the world4");
        map.put("fuck", "the world5");
        map.put("haha", "the world6");
        map.put("haha2", "the world7");
        map.delete("fuck");
        System.out.println(map);
        System.out.println(map.get("fuck1"));
        System.out.println(map.get("fuck2"));
        System.out.println(map.get("haha"));
        System.out.println(map.get("haha2"));
    }
}
