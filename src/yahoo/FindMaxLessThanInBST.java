/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindMaxLessThanInBST.java
 *         Version:   1.0
 *         Created:   4/24 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find the maximum value which is less than the target value in BST.(see evernote)
 *            
 * All rights reserved.
 ******************************************************************************/
package yahoo;

import java.io.IOException;

import util.TreeNode;

public class FindMaxLessThanInBST {

    public int search(TreeNode root, int target) throws IOException {
        if (root == null) {
            throw new IOException("root cannot be null");
        }
        TreeNode cur = root;
        int max = Integer.MIN_VALUE;
        while (cur != null) {
            max = cur.val < target ? Math.max(max, cur.val) : max;
            if (target <= cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        FindMaxLessThanInBST test = new FindMaxLessThanInBST();
        TreeNode node1 = new TreeNode(-5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(-2);
        TreeNode node5 = new TreeNode(-3);
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(test.search(node1, 1));
    }
}
