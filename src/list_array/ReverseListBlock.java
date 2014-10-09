/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ReverseListBlock.java
 *         Created:   9/23
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   k = 2, list = [1,2,3,4,5,6,7,8,9], the reversed list is [8,9,6,7,4,5,2,3,1]
 *            
 * All rights reserved.
 ******************************************************************************/
package list_array;

import java.util.Arrays;
import java.util.List;
import util.ListNode;

public class ReverseListBlock {
    //just like a insertion sort, each time we need insert the block into first position 
    public static ListNode reverse(ListNode list, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        int listLen = getLen(list);
        int firstBlockSize = listLen % k;
        ListNode start = list;
        if (firstBlockSize != 0) {
            start = reverseBlock(dummy, start, firstBlockSize);
        }
        int numBlock = (listLen) / k;
        for (int i = 0; i < numBlock; i++) {
            start = reverseBlock(dummy, start, k);
        }
        return dummy.next;
    }

    public static ListNode reverseBlock(ListNode dummy, ListNode start, int blockSize) {
        ListNode end = start;
        while (blockSize > 1) {
            end = end.next;
            blockSize--;
        }
        ListNode temp = end.next;
        end.next = dummy.next;
        dummy.next = start;
        return temp;
    }

    public static int getLen(ListNode list) {
        ListNode iter = list;
        int len = 0;
        while (iter != null) {
            len++;
            iter = iter.next;
        }
        return len;
    }

    /** Test @return {@link ListNode} head of the linked list containing the given values */
    static ListNode createFromList(List<Integer> list) {
        ListNode head = null;
        ListNode node = null;
        for (int val : list) {
            ListNode prev = node;
            node = new ListNode(val);
            if (head == null)
                head = node;

            if (prev != null)
                prev.next = node;
        }

        return head;
    }

    /** Test Prints the linked lists */
    static String printLinkedList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode node = head;
        while (node != null) {
            if (node != head)
                sb.append(',');
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode testLinkedList = createFromList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(printLinkedList(testLinkedList));
        ListNode reversed = reverse(testLinkedList, 2);
        System.out.println(printLinkedList(reversed));
    }
}
