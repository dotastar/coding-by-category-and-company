/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PostorderTraverseInMultiTree.java
 *         Created:   Nov 15, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to traverse a multi-tree in Postorder    
 *                    
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.ArrayList;
import java.util.Stack;

import util.TreeNode;

public class PostorderTraverseInMultiTree {
    public ArrayList<Integer> postOrderTraverse(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> count = new Stack<Integer>();
        stack.push(root);
        count.push(0);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            int curCount = count.pop();
            if (curCount < curNode.children.size()) {
                stack.push(curNode);
                count.push(Integer.valueOf(curCount + 1));
                if (curNode.children.get(curCount) != null) {
                    stack.push(curNode.children.get(curCount));
                    count.push(0);
                }
            } else {
                ans.add(curNode.id);
            }
        }
        return ans;
    }
}
