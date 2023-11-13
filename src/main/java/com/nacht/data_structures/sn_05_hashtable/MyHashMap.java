package com.nacht.data_structures.sn_05_hashtable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2023/11/13 20:42
 */
public class MyHashMap<K, V> {

    @Data
    @AllArgsConstructor
    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair() {
        }
    }

    /**
     * 数据存储数组
     */
    private Node<Pair<K, V>>[] elements;
    /**
     * 集合大小
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    @SuppressWarnings("unchecked")
    MyHashMap(int capacity){
        this.elements = (Node<Pair<K, V>>[]) new Node[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 获取集合大小
     */
    public int size() {
        return this.size;
    }

    /**
     * 计算key的hash值
     */
    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 计算key的bucket
     */
    private int getBucket(Object key) {
        int hashValue = hash(key);
        return hashValue % this.capacity;
    }

    /**
     * 新增元素
     */
    public void put(K key, V value){
        int bucketIndex = getBucket(key);
        Node<Pair<K, V>> head = this.elements[bucketIndex];
        if(head == null){
            head = new Node<>(new Pair<>());
            this.elements[bucketIndex] = head;
        }
        Node<Pair<K, V>> next = head.getNext();
        boolean isExist = false;
        while(next != null){
            /*找到了相同key的节点, 直接更新该节点*/
            if(next.getValue().getKey() == key){
                isExist = true;
                next.getValue().setValue(value);
                break;
            }else{
                next = next.getNext();
            }
        }
        if(!isExist){
            Node<Pair<K, V>> node = new Node<>(new Pair<>(key, value));
            node.setNext(head.getNext());
            head.setNext(node);
        }
        this.size ++;
    }

    /**
     * 删除
     */
    public void delete(Object key){
        int bucketIndex = getBucket(key);
        Node<Pair<K, V>> head = this.elements[bucketIndex];
        Node<Pair<K, V>> next = head.getNext();
        Node<Pair<K, V>> current = head;
        while(next != null){
            /*找到了相同key的节点, 直接更新该节点*/
            if(next.getValue().getKey() == key){
                Node<Pair<K, V>> nextOfNext = next.getNext();
                next.setNext(null);
                current.setNext(nextOfNext);
                this.size --;
                break;
            }else{
                current = next;
                next = next.getNext();
            }
        }
    }

    /**
     * 获取value
     */
    public V get(K key){
        int bucketIndex = getBucket(key);
        Node<Pair<K, V>> head = this.elements[bucketIndex];
        Node<Pair<K, V>> next = head.getNext();
        while(next != null){
            /*找到了相同key的节点, 直接更新该节点*/
            if(next.getValue().getKey() == key){
                return next.getValue().getValue();
            }else{
                next = next.getNext();
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Node<Pair<K, V>> element: elements){
            result.append(nodeToString(element));
            result.append("\r\n");
        }
        return result.toString();
    }

    private String nodeToString(Node<Pair<K, V>> node){
        StringBuilder value = new StringBuilder(node.getValue().toString());
        Node<Pair<K, V>> next = node.getNext();
        while (next != null){
            value.append(" => ");
            value.append(next.getValue().toString());
            next = next.getNext();
        }
        return value.toString();
    }
}
