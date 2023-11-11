package com.nacht.data_structures.sn_04_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Nacht
 * Created on 2023/11/11 16:16
 */
public class QueueTest {

    public static void main(String[] args) throws Exception {
        testJdkQueue();
        AbstractQueue queue1 = new QueueOverLinkedList();
        AbstractQueue queue2 = new QueueOverArray(5);
        testMyQueue(queue1);
        testMyQueue(queue2);
    }

    public static void testMyQueue(AbstractQueue queue){
        /* 元素入队 */
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);
        /* 访问队首元素 */
        int peek = queue.peek();
        System.out.println(peek); // 1
        /* 元素出队 */
        int pop = queue.pop();
        System.out.println(pop); // 1
        pop = queue.pop();
        System.out.println(pop); // 3
        pop = queue.pop();
        System.out.println(pop); // 2
        pop = queue.pop();
        System.out.println(pop); // 5
        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println(size); // 1
        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println(isEmpty); // false
    }

    public static void testJdkQueue(){
        /* 初始化队列 */
        Queue<Integer> queue = new LinkedList<>();

        /* 元素入队 */
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);

        /* 访问队首元素 */
        int peek = queue.peek();
        System.out.println(peek); // 1
        /* 元素出队 */
        int pop = queue.poll();
        System.out.println(pop); // 1
        pop = queue.poll();
        System.out.println(pop); // 3
        pop = queue.poll();
        System.out.println(pop); // 2
        pop = queue.poll();
        System.out.println(pop); // 5
        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println(size); // 1
        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println(isEmpty); // false
    }


}
