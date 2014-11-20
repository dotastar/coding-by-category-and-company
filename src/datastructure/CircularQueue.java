/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FixedQueue.java
 *         Created:   2/19
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   1. enqueue: if queue is full, we throw a exception.
 *                    2. dequeue: if queue is empty, we throw a exception/
 *            
 * All rights reserved.
 ******************************************************************************/

package datastructure;

import java.io.IOException;

public class CircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int curSize;

    public CircularQueue(int initS) {
        this.queue = new int[initS];
        this.head = 0;
        this.tail = 0;
        this.curSize = 0;
    }

    public void enqueue(int val) throws IOException {
        if (this.curSize == queue.length) {
            throw new IOException("Queue is Full.");
        }
        queue[tail] = val;
        tail = (tail + 1) % queue.length;
        this.curSize++;
    }

    public int dequeue() throws IOException {
        if (this.curSize == 0) {
            throw new IOException("Queue is Empty.");
        }
        int item = queue[head];
        head = (head + 1) % queue.length;
        this.curSize--;
        return item;
    }

    public static void main(String[] args) throws IOException {
        CircularQueue test = new CircularQueue(3);
        test.enqueue(3);
        test.enqueue(3);
        test.enqueue(3);
        test.dequeue();
        test.dequeue();
        test.dequeue();
        test.enqueue(4);
        test.enqueue(5);
        test.dequeue();
        test.dequeue();
    }
}
