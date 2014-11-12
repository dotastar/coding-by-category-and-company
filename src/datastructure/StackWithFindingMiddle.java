/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StackWithFindingMiddle.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to implement a stack which will support following operations in O(1) time complexity?
 *                    1) push() which adds an element to the top of stack.
 *                    2) pop() which removes an element from top of stack.
 *                    3) findMiddle() which will return middle element of the stack.
 *                    The idea is to use Doubly Linked List (DLL). We can delete middle element in O(1) time by maintaining mid pointer.
 * All rights reserved.
 ******************************************************************************/
package datastructure;

import java.io.IOException;

import util.DLLNode;

public class StackWithFindingMiddle {
    public DLLNode head;
    public DLLNode mid;
    public int count;

    public void push(int newData) {
        DLLNode newNode = new DLLNode(newData);
        newNode.prev = null;
        newNode.next = head;
        this.count++;
        //change mid pointer in two cases:
        //1. LinkedList is Empty; 2. Number of nodes in LinkedList is odd
        if (this.count == 1) {
            this.mid = newNode;
        } else {
            this.head.prev = newNode;
            if (this.count % 2 != 0) {
                this.mid = this.mid.prev;
            }
        }
    }

    public int pop() throws IOException {
        if (this.count == 0) {
            throw new IOException("the stack is empty!");
        }
        DLLNode top = this.head;
        int item = top.data;
        this.head = this.head.next;
        //if linkedlist doesn't become empty, update prev of new head
        if (this.head != null) {
            this.head.prev = null;
        }
        this.count -= 1;
        //update the mid pointer when we have even number of elements in the stack, i,e move down the mid pointer.
        if (this.count % 2 == 0) {
            this.mid = this.mid.next;
        }
        return item;
    }

    public int findMiddle() throws IOException {
        if (this.count == 0) {
            throw new IOException("the stack is empty!");
        }
        return this.mid.data;
    }
}
