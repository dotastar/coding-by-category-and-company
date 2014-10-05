/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SerializeTree.java
 *         Created:   Oct 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to serialize a tree(multiple nodes)
 *                    
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.LinkedList;

import util.TreeNode;

public class SerializeTree {
    /**
     * this preorder serialization is better than level order serialization
     * because we can get all subtree serialization by only traversing once. But LOS must do this in O(n^2)
     */
    public void serialize(TreeNode root, LinkedList<Integer> structure, LinkedList<Integer> ids) {
        structure.add(root.children.size());
        ids.add(root.id);
        for (TreeNode child : root.children) {
            serialize(child, structure, ids);
        }
    }
}
