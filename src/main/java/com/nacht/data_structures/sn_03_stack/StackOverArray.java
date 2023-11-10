package com.nacht.data_structures.sn_03_stack;

import java.util.ArrayList;

/**
 * @author Nacht
 * Created on 2023/11/10 22:54
 */
public class StackOverArray {
    /**
     * stack data
     */
    private final ArrayList<Integer> data = new ArrayList<>();


    /**
     * first,
     * @param value value to push into the stack
     */
    public void push(Integer value){
        this.data.add(value);
    }

    /**
     * peek the stack!
     */
    public Integer peek(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("there is no element in stack for peeking.");
        }
        return this.data.get(data.size() - 1);
    }

    /**
     * pop out top element of the stack
     */
    public Integer pop(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("there is no element in stack for popping.");
        }
        return this.data.remove(this.data.size() - 1);
    }

    /**
     * return a flag that marks whether the stack is empty.
     */
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
}
