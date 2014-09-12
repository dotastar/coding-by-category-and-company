/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FixedQueue.java
 *         Version:   1.0
 *         Created:   2/19
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   1. enqueue: if full, remove the least recently added element of the queue
 *                    2. dequeue: if empty, throw a exception
 *            
 * All rights reserved.
 ******************************************************************************/

package informatica;

import java.io.IOException;

public class FixedQueue {
    private int[] fixQueue;
    private int head;
    private int tail;
    private int elemSize;

    public FixedQueue(int size) {
        fixQueue = new int[size];
        head = 0;
        tail = 0;
        elemSize = 0;
    }

    public void enqueue(int val) {
        if (head != tail) {
            fixQueue[tail] = val;
            tail = (tail + 1) % fixQueue.length;
            elemSize = elemSize < fixQueue.length ? elemSize + 1 : elemSize;
        } else {
            head = elemSize == fixQueue.length ? (head + 1) % fixQueue.length : head;
            fixQueue[tail] = val;
            tail = (tail + 1) % fixQueue.length;
            elemSize = elemSize < fixQueue.length ? elemSize + 1 : elemSize;
        }
        System.out.println("enqueue--");
        System.out.println("head " + head + " - " + "Tail" + tail);
    }

    public int dequeue() throws IOException {
        if (elemSize == 0) {
            throw new IOException("empty!");
        }
        int temp = fixQueue[head];
        head = (head + 1) % fixQueue.length;
        elemSize = elemSize - 1;
        System.out.println("dequeue**");
        System.out.println("head " + head + " - " + "Tail" + tail);
        return temp;
    }

    public static void main(String[] args) throws IOException {
        FixedQueue test = new FixedQueue(3);
        test.enqueue(3);
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
