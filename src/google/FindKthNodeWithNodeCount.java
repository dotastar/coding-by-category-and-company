/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindKthNodeWithNodeCount.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   You have a binary tree where each node knows the number of nodes in its sub-tree (including itself). 
 *                    Given a node n and an int k, write a function to return the kth node in an in order traversal. 
 *                    Can you do this non recursively
 * All rights reserved.
 ******************************************************************************/
package google;

public class FindKthNodeWithNodeCount {
    public class Node {
        public Node left;
        public Node right;
        public int count;
    }

    public Node findKthNode(Node root, int k) {//k start from 0
        if (k < 0 || k >= root.count) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            if (cur.left != null && k < cur.left.count) {
                cur = cur.left;
                continue;
            }
            k = k - cur.left.count;
            if (k == 0) {
                break;
            } else {
                cur = cur.right;
                k--;
            }
        }
        return cur;
    }
}
