/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SwapEachTwoNodeInList.java
 *         Created:   4/24
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   swap each two elements in a list. eg. a, b, c, d, e -> b, a, d, c, e
 *            
 * All rights reserved.
 ******************************************************************************/
package yahoo;

import util.ListNode;

public class SwapEachTwoNodeInList {
    public ListNode swap(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, suc = head.next;
        while(cur != null && suc != null){
            pre.next = suc;
            cur.next = suc.next;
            suc.next = cur;
            pre = cur;
            cur = cur.next;
            suc = cur == null ? null : cur.next;//NOTE
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        SwapEachTwoNodeInList test = new SwapEachTwoNodeInList();
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode newHead = test.swap(node1);
        ListNode iter = newHead;
        while(iter != null){
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
    }
}
