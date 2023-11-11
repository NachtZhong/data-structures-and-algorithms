package com.nacht.data_structures.sn_04_queue;

/**
 * @author Nacht
 * Created on 2023/11/11 11:48
 */
public abstract class AbstractQueue {

    abstract boolean isEmpty();
    abstract int size();
    abstract void push(Integer element);
    abstract Integer pop();
    abstract Integer peek();


}
