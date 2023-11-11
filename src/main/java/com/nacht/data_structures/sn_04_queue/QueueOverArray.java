package com.nacht.data_structures.sn_04_queue;

import java.util.Arrays;

/**
 * 基于数组实现的队列
 * @author Nacht
 * Created on 2023/11/11 02:33
 */
public class QueueOverArray extends AbstractQueue{

    /**
     * 队列数据存储数组
     */
    int[] elements;

    /**
     * 队头
     */
    int front;

    /**
     * 队列长度
     */
    int queueSize;


    QueueOverArray(int capacity) throws Exception {
        if(capacity <= 0){
            throw new Exception("容量必须大于等于1");
        }
        this.elements = new int[capacity];
        this.front = 0;
        this.queueSize = 0;
    }

    @Override
    boolean isEmpty() {
        return this.size()== 0;
    }

    @Override
    int size() {
        return this.queueSize;
    }


    @Override
    void push(Integer element) {
        if(queueSize >= this.elements.length){
            throw new IndexOutOfBoundsException("队列已满");
        }
        this.elements[this.getRearIndex()] = element;
        this.queueSize ++;
    }

    /**
     * 获取尾节点索引
     */
    private int getRearIndex(){
        return (this.front + this.queueSize) % this.elements.length;
    }

    @Override
    Integer pop() {
        int value = this.peek();
        this.elements[this.front] = 0;
        this.front = (this.front + 1) % this.elements.length;
        this.queueSize --;
        return value;
    }

    @Override
    Integer peek() {
        if(this.size() == 0){
            throw new IndexOutOfBoundsException("队列为空");
        }
        return this.elements[this.front];
    }

    @Override
    public String toString() {
        return "QueueOverArray{" +
                "elements=" + Arrays.toString(elements) +
                ", front=" + front +
                ", queueSize=" + queueSize +
                '}';
    }
}
