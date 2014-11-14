/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BuildSpecialBTFromInorderTraversal.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in left and right children,
 *                    construct the Binary Tree and return root.
 *                    The maximum element in given array must be root.
 *                    The elements on left side of the maximum element are in left subtree and elements on right side are in right subtree.
 *                    eg. {1, 5, 10, 40, 30, 15, 28, 20}.
 *                                    40
 *                                 /       \  
 *                            {1,5,10}   {30,15,28,20}
 * All rights reserved.
 ******************************************************************************/
package tree;

import util.BinaryTreeNode;

public class BuildSpecialBTFromInorderTraversal {

    public BinaryTreeNode buildTree(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int i = searchMax(inorder, start, end);
        BinaryTreeNode root = new BinaryTreeNode(inorder[i]);
        root.left = buildTree(inorder, start, i - 1);
        root.right = buildTree(inorder, i + 1, end);
        return root;
    }

    public int searchMax(int[] inorder, int start, int end) {
        int max = inorder[start], maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (inorder[i] > max) {
                max = inorder[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
