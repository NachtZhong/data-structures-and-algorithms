package com.nacht.data_structures.sn_03_stack;

import java.util.Stack;

/**
 * @author Nacht
 * Created on 2023/11/10 16:59
 */
public class StackTest {
    public static void main(String[] args) {
        myStackTest2();
    }
    public static void jdkStackTest(){
        /* push sth into stack */
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        /* peek */
        System.out.println(stack.peek()); //5
        /* pop */
        System.out.println(stack.pop()); //5
        System.out.println(stack.pop()); //4
        System.out.println(stack.pop()); //3
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.pop()); //exception
    }

    public static void myStackTest1(){
        /* push sth into stack */
        StackOverLinkedList stack = new StackOverLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        /* peek */
        System.out.println(stack.peek()); //5
        /* pop */
        System.out.println(stack.pop()); //5
        System.out.println(stack.pop()); //4
        System.out.println(stack.pop()); //3
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.pop()); //exception
    }

    public static void myStackTest2(){
        /* push sth into stack */
        StackOverArray stack = new StackOverArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        /* peek */
        System.out.println(stack.peek()); //5
        /* pop */
        System.out.println(stack.pop()); //5
        System.out.println(stack.pop()); //4
        System.out.println(stack.pop()); //3
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.pop()); //exception
    }
}
