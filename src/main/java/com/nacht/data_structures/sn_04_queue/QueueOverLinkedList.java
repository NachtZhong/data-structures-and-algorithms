package com.nacht.data_structures.sn_04_queue;

/**
 * 基于链表实现的队列
 * @author Nacht
 * Created on 2023/11/11 02:33
 */
public class QueueOverLinkedList extends AbstractQueue{

    /**
     * 头尾节点
     */
    private Node<Integer> front, rear;
    /**
     * 队列大小
     */
    private int queueSize;

    QueueOverLinkedList(){
        this.queueSize = 0;
    }

    /**
     * 当前队列长度
     */
    @Override
    public int size(){
        return this.queueSize;
    }

    /**
     * 当前队列是否为空
     */
    @Override
    public boolean isEmpty(){
        return this.queueSize == 0;
    }

    /**
     * 入队
     */
    @Override
    public void push(Integer i){
        Node<Integer> element = new Node<>(i);
        // 队列为空, 则直接把头尾设成当前节点即可
        if(this.isEmpty()){
            this.front = element;
            this.rear = element;
        }else{
            // 队列非空, 丢到队尾排队
            this.rear.setNext(element);
            this.rear = element;
        }
        this.queueSize ++;
    }

    /**
     * 出队
     */
    @Override
    public Integer pop(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("当前队列中没有元素");
        }
        Node<Integer> element = this.front;
        this.front = this.front.getNext();
        this.queueSize --;
        // 如果队列为空, 将尾指针置空
        if(this.isEmpty()){
            this.rear = null;
        }
        return element.getValue();
    }

    /**
     * 查看第一个元素
     */
    @Override
    public Integer peek(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("当前队列中没有元素");
        }
        return this.front.getValue();
    }

    @Override
    public String toString() {
        return "QueueOverLinkedList{" +
                "front=" + front +
                ", rear=" + rear +
                ", queueSize=" + queueSize +
                '}';
    }
}
