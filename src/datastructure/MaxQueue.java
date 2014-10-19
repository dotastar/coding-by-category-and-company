/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaxQueue.java
 *         Created:   Oct 17, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to implement a queue with getMax() in O(1) time complexity
 *                    
 * All rights reserved.
 ******************************************************************************/
package datastructure;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MaxQueue {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    public void add(int data) {
        queue.add(data);
        while(!deque.isEmpty() && deque.peekLast() <= data){
            deque.pollLast();
        }
        deque.add(data);
    }

    public int pollFirst() {
        if(queue.peekFirst() == deque.peekFirst()){
            deque.pollFirst();
        }
        return queue.pollFirst();
    }

    public int getMax() {
        return deque.peekFirst();
    }
}
