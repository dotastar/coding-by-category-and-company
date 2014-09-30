/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   QuickSortList.java
 *         Version:   1.0
 *         Created:   2/14 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Sort a linked list in O(n log n) time using constant space complexity.
 *            
 * All rights reserved.
 ******************************************************************************/
package misc;


public class QuickSortList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode[] quickSort(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode[] pHeaders = partition(head);
        ListNode[] left = quickSort(pHeaders[0]);
        ListNode[] right = quickSort(pHeaders[1].next);
        return connect(left, pHeaders[1], right);//NOTE decrease input size when dividing sub-problems in case of infinite loop
    }

    public ListNode[] partition(ListNode head) {
        ListNode dummyLeft = new ListNode(0), dummyRight = new ListNode(0);
        ListNode iter = head, iterLeft = dummyLeft, iterRight = dummyRight;
        int mid = head.val;
        while (iter != null) {
            if (iter.val < mid) {
                iterLeft.next = iter;
                iterLeft = iterLeft.next;
            } else {
                iterRight.next = iter;
                iterRight = iterRight.next;
            }
            iter = iter.next;
        }
        iterLeft.next = null;
        iterRight.next = null;
        return new ListNode[] { dummyLeft.next, dummyRight.next };
    }

    public ListNode[] connect(ListNode[] left, ListNode mid, ListNode[] right) {
        ListNode[] headTail = new ListNode[2];
        if (left != null) {
            left[1].next = mid;
            headTail[0] = left[0];
        } else {
            headTail[0] = mid;
        }
        if (right != null) {
            mid.next = right[0];
            headTail[1] = right[1];
        } else {
            headTail[1] = mid;
        }
        return headTail;
    }
    
    public static void main(String[] args) {
        QuickSortList test = new QuickSortList();
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(0);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode[] res = test.quickSort(a);
        ListNode iter = res[0];
        while (iter != null) {
            System.out.println(iter.val);
            iter = iter.next;
        }
    }
}
