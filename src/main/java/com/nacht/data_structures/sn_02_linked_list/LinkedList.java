package com.nacht.data_structures.sn_02_linked_list;

/**
 * @author Nacht
 * Created on 2023/11/10 13:16
 */
public class LinkedList {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        Node<Integer> node8 = new Node<>(8);
        Node<Integer> node9 = new Node<>(9);
        Node<Integer> tail = new Node<>(10);
        /* set next node for each node */
        head.setNext(node1)
                .setNext(node2)
                .setNext(node3)
                .setNext(node4)
                .setNext(node5)
                .setNext(node6)
                .setNext(node7)
                .setNext(node8)
                .setNext(node9)
                .setNext(tail)
                .setNext(null);
        printLinkedList(head);  // 0 => 1 => 2 => 3 => 4 => 5 => 6 => 7 => 8 => 9 => 10
        /* insert new node between 2 and 3 */
        Node<Integer> insertNode = new Node<>(100);
        node2.setNext(insertNode);
        insertNode.setNext(node3);
        printLinkedList(head);  // 0 => 1 => 2 => 100 => 3 => 4 => 5 => 6 => 7 => 8 => 9 => 10
        /* delete node between 2 and 3 */
        node2.setNext(node3);
        printLinkedList(head);  // 0 => 1 => 2 => 3 => 4 => 5 => 6 => 7 => 8 => 9 => 10
        /* get node value by index */
        System.out.println(getNodeValueByIndex(head, 7));  // 7
        /* search by value */
        System.out.println(searchIndexByValue(head, 9));  // 9
        System.out.println(searchIndexByValue(head, 11));  // -1

    }

    /**
     * search by value
     */
    private static Integer searchIndexByValue(Node<Integer> head, int value){
        Node<Integer> current = head;
        for(int index = 0; current.getNext() != null; index++, current=current.getNext()){
            if(current.getValue() == value){
                return index;
            }
        }
        return -1;
    }

    /**
     * get node value by index
     */
    private static Integer getNodeValueByIndex(Node<Integer> head, int index){
        Node<Integer> current = head;
        for(int i = 0; i < index; i ++){
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * print linked list node values
     */
    private static void printLinkedList(Node<Integer> head){
        Node<Integer> current = head;
        while(true){
            System.out.print(current.getValue());
            current = current.getNext();
            if(current == null){
                break;
            }
            System.out.print(" => ");

        }
        System.out.println();
    }
}
