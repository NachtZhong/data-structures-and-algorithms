package com.nacht.data_structures.sn_03_stack;

/**
 * @author Nacht
 * Created on 2023/11/10 13:12
 */
public class Node<V> {

    public Node(V value){
        this.value = value;
    }

    private V value;
    private Node<V> next;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getNext() {
        return next;
    }

    public Node<V> setNext(Node<V> next) {
        this.next = next;
        return this.next;
    }
}
