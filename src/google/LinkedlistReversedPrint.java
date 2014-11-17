/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LinkedlistReversedPrint.java
 *         Created:   Nov 15, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   print Linkedlist in a reversed way.
 *                    This method reduce the space complexity to O(n^0.5)
 *                    k: the size of storing head of partial list
 *                    n: the size of partial list
 *                    so k*n = N, if k inc, then n dec; else k dec, n inc;
 *                    so the optimal of this formual is to set k = n
 *                    n = N^(1/2). 
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.Stack;

import util.ListNode;

public class LinkedlistReversedPrint {
    public void print(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        int nSquare = (int) Math.pow(getListSize(head), 0.5), i = 0;
        ListNode prev = head, cur = head;
        while (cur != null) {
            if ((++i) == nSquare) {
                stack.push(prev);
                prev = cur.next;
                cur.next = null;
                cur = prev;
                i = 0;
            } else {
                cur = cur.next;
            }
        }
        if (i > 0) {
            stack.push(prev);
        }
        while (!stack.isEmpty()) {
            printRecurisve(stack.peek());
            stack.pop();
        }
    }

    public void printRecurisve(ListNode head) {
        if (head.next == null) {
            System.out.println(head.val);
            return;
        }
        printRecurisve(head.next);
        System.out.println(head.val);
    }

    public int getListSize(ListNode head) {
        int size = 0;
        ListNode iter = head;
        while (iter != null) {
            size++;
            iter = iter.next;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        LinkedlistReversedPrint test = new LinkedlistReversedPrint();
        test.print(a);
    }
}
