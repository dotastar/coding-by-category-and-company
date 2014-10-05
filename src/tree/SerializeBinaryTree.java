/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SerializeBinaryTree.java
 *         Created:   Oct 1, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Two different ways to serialize binary tree
 *                    http://en.wikipedia.org/wiki/Binary_tree#Encodings
 *                    
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.LinkedList;

import util.BinaryTreeNode;

public class SerializeBinaryTree {
    /**
     * preorder serialization is better than level order serialization
     * because we can get all subtree serialization by only traversing once. But LOS must do this in O(n^2)
     * NOTE Shortcoming:a placeholder(null) is required to represent empty nodes.
     * What if we need to store strings that can contain any characters (including the placeholder) in the binary tree?
     */
    public void serialize(BinaryTreeNode root, LinkedList<Integer> outstream) {
        if (root == null) {
            outstream.add(null);
        }
        outstream.add(root.val);
        serialize(root.left, outstream);
        serialize(root.right, outstream);
    }

    /**
     * this solution is better than the upper one. because we don't need to record placeholder
     * we use bits stream to record the structure of binary tree, 1 means non-null node, and 0 means null node
     * the length of bits stream if n + 1(think why? n is internal nodes), which we convert this bits stream into a single number
     * the data records all values of internal nodes in binary tree, which use less storage than upper outstream  
     */
    public void serialize(BinaryTreeNode root, StringBuilder bitStructure, LinkedList<Integer> data) {
        if (root == null) {
            bitStructure.append(0);
        } else {
            bitStructure.append(1);
            data.add(root.val);
            serialize(root.left, bitStructure, data);
            serialize(root.left, bitStructure, data);
        }
    }
}
