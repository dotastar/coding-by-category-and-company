/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   InterleaveTwoLinkedList.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given two linkedlist: eg 1-2-3-4, 5-6
 *                    return 1-5-2-6-3-4
 * All rights reserved.
 ******************************************************************************/
package facebook;

import util.ListNode;

public class InterleaveTwoLinkedList {
    public ListNode interleave(ListNode p, ListNode q) {
        if (p == null && q == null) {
            return null;
        }
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        q.next = interleave(p.next, q.next);
        p.next = q;
        return p;
    }
}
