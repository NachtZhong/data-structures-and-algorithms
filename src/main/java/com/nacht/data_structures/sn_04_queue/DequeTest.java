package com.nacht.data_structures.sn_04_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Nacht
 * Created on 2023/11/12 10:12
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        /*插队*/
        deque.offerFirst(4);
        System.out.println(deque); //4,1,2,3
        int pop = deque.pollLast();
        System.out.println(pop); //3
    }
}
