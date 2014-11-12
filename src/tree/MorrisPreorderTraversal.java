/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MorrisPreorderTraversal.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Refer: http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 *                    Moriss Preorder traversal
 *                    
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.ArrayList;

import util.BinaryTreeNode;

public class MorrisPreorderTraversal {
    public ArrayList<Integer> inorderTraverse(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        //cur is traversal pointer, prev is prev traversal point of cur point
        BinaryTreeNode cur = root, prev = null;
        while (cur != null) {
            if (cur.left == null) {//find the first point to print, we use right child to pop back!
                ans.add(cur.val);
                cur = cur.right;
            } else {//NOTE
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {//find prev point, print cur point
                    ans.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                } else {//recover prev point's right pointer
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
