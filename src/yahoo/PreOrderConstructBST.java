/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PreorderConstructBST.java
 *         Created:   Oct 1, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   I assume this BST doesn't contain dup. 
 *                    even if it contains dup, it still would be easy to be implemented.
 *                    
 * All rights reserved.
 ******************************************************************************/
package yahoo;

import util.BinaryTreeNode;

public class PreorderConstructBST {

    private int idx = 0;

    public BinaryTreeNode constructRec(int[] input, int min, int max) {
        BinaryTreeNode root = null;
        if (idx >= input.length) {
            return null;
        }
        if (input[idx] > min && input[idx] < max) {
            root = new BinaryTreeNode(input[idx]);
            idx++;
            root.left = constructRec(input, min, root.val);
            root.right = constructRec(input, root.val, max);
        }
        return root;
    }

    public BinaryTreeNode construct(int[] input) {
        return constructRec(input, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
