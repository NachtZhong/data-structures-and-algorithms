package com.nacht.util;

import com.nacht.data_structures.basic.Node;

import java.util.Arrays;

/**
 * 打印各种数据结构的
 * @author Nacht
 * Created on 2023/11/16 20:25
 */
public class PrettyPrintUtil {

    public static <T>  void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static <T> void printLinkedList(Node<T> node){
        StringBuilder listStr = new StringBuilder();
        listStr.append(node.getValue());
        Node<T> next = node.getNext();
        while (next != null){
            listStr.append(" => ").append(next.getValue());
            next = next.getNext();
        }
        System.out.println(listStr);
    }

    public static void main(String[] args) {

        Node<Integer> node = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        node.setNext(node2);
        printLinkedList(node);
        printArray(new Node[]{node, node});
    }

}
