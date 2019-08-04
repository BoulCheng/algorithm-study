package com.zlb.data.structure;

/**
 * @author Yuanming Tao
 * Created on 2019/8/4
 * Description 数组实现队列
 */
public class Queue {

    private int head;
    private int tail;

    private Object[] queue;

    public Queue(int size) {
        // 只能存放 size - 1 个元素， tail 不存放任何元素
        this.queue = new Object[size];
    }

    public void enqueue(Object object) {
        if (head == tail + 1) {
            throw new RuntimeException("queue overflow");
        }
        queue[tail] = object;
        if (tail == queue.length - 1) {
            tail = 0;
        } else {
            tail = tail + 1;
        }
    }

    public Object dequeue() {
        if (head == tail) {
            throw new RuntimeException("queue underflow");
        }
        Object object = queue[head];
        queue[head] = null;
        if (head == queue.length - 1) {
            head = 0;
        } else {
            head = head + 1;
        }
        return object;
    }


    public static void main(String[] args) {
        Queue queue = new Queue(10);

        for (int i = 0; i < 5; i++) {
            queue.enqueue(new Object());
        }

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        try {
            queue.dequeue();
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 9; i++) {
            queue.enqueue(new Object());
        }

        try {
            queue.enqueue(new Object());
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            queue.dequeue();
        }

    }




}
