/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BlockingQueue.java
 *         Created:   Sep 29, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   implemented a bounded blocking queue
 *                    
 * All rights reserved.
 ******************************************************************************/
package javabasic;

import java.util.LinkedList;

public class BlockingQueue {
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    private int limit;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void enqueue(int item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(item);
    }

    public synchronized int dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }
        return this.queue.pollFirst();
    }
}
