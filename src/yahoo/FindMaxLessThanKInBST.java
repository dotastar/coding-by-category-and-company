/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindMaxLessThanInBST.java
 *         Created:   4/24 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to find largest element smaller than K in a BST(may has duplicates)
 *                    http://stackoverflow.com/questions/6334514/to-find-largest-element-smaller-than-k-in-a-bst
 *            
 * All rights reserved.
 ******************************************************************************/
package yahoo;

import java.io.IOException;

import util.BinaryTreeNode;

public class FindMaxLessThanKInBST {

    public int search(BinaryTreeNode root, int target) throws IOException {
        if (root == null) {
            throw new IOException("root cannot be null");
        }
        int ans = target; 
        while (root != null) {
            if (target <= root.val) {
                root = root.left;
            } else {
                ans = root.val;
                root = root.right;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        FindMaxLessThanKInBST test = new FindMaxLessThanKInBST();
        BinaryTreeNode node1 = new BinaryTreeNode(-5);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(-1);
        BinaryTreeNode node4 = new BinaryTreeNode(-2);
        BinaryTreeNode node5 = new BinaryTreeNode(-3);
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(test.search(node1, 1));
    }
}
