package com.nacht.data_structures.sn_03_stack;

import com.nacht.data_structures.basic.Node;
import lombok.Data;

/**
 * 链表头插法实现栈
 * @author Nacht
 * Created on 2023/11/10 18:16
 */
@Data
public class StackOverLinkedList {

    /**
     * top node of the stack, which is also first node of the linked list
     */
    private Node<Integer> stackPeek;

    /**
     * size of the stack and linked list
     */
    private int size = 0;

    /**
     * first, init a new element and make it's next node to current stack peek;
     * then, mark element as new stack peek;
     * finally, increase the stack size;
     * @param value value to push into the stack
     */
    public void push(Integer value){
        Node<Integer> element = new Node<>(value);
        element.setNext(stackPeek);
        this.stackPeek = element;
        this.size ++;
    }

    /**
     * peek the stack!
     */
    public Integer peek(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("there is no element in stack for peeking.");
        }
        return this.stackPeek.getValue();
    }

    /**
     * pop out top element of the stack
     */
    public Integer pop(){
        int value = peek();
        this.stackPeek = this.stackPeek.getNext();
        this.size --;
        return value;
    }

    /**
     * return a flag that marks whether the stack is empty.
     */
    public boolean isEmpty(){
        return this.size == 0;
    }



}
