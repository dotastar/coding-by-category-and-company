/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DeserializeBinaryTree.java
 *         Created:   Oct 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Two ways to deserialize Binary Tree
 *                    
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.LinkedList;

import util.BinaryTreeNode;

public class DeserializeBinaryTree {
    public BinaryTreeNode deserialize(LinkedList<Integer> outstream) {
        Integer val = outstream.pollFirst();
        if(val == null){
            return null;
        }else{
            BinaryTreeNode root = new BinaryTreeNode(val);
            root.left = deserialize(outstream);
            root.right = deserialize(outstream);
            return root;
        }
    }
    
    public BinaryTreeNode deserialize(StringBuilder bitStructure, LinkedList<Integer> data) {
        char bit = bitStructure.charAt(0);
        bitStructure.deleteCharAt(0);
        if(bit == '0'){
            return null;
        }else{
            BinaryTreeNode root = new BinaryTreeNode(data.pollFirst());
            root.left = deserialize(bitStructure, data);
            root.right = deserialize(bitStructure, data);
            return root;
        }
    }
}
