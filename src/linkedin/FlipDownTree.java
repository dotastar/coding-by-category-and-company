/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FlipDownTree.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32775405.html
 *            
 * All rights reserved.
 ******************************************************************************/

package linkedin;

import util.TreeNode;

public class FlipDownTree {
    public TreeNode reverseTree(TreeNode root) {
        TreeNode cur = root, curSib = null;
        while (cur != null) {
            TreeNode left = cur.left, right = cur.right;
            cur.right = curSib;
            cur = left;
            curSib = right;
        }
        cur = root;
        TreeNode parent = null;
        while (cur != null) {
            TreeNode next = cur.left;
            cur.left = cur.right;
            cur.right = parent;
            parent = cur;
            cur = next;
        }
        return parent;
    }
}
