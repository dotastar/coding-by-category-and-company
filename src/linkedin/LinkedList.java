/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LinkedList.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32655311.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

public class LinkedList {

    private class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void appendToTail(int d) {
        Node end = new Node(d);
        if (tail != null) {
            tail.next = end;
        }
        tail = end;
    }

    public void deleteNode(int d) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node iter = dummy;
        while (iter.next != null) {
            if (iter.next.data == d) {
                iter.next = iter.next.next;
                break;
            }
        }
        head = dummy.next;
        dummy.next = null;
    }
}
