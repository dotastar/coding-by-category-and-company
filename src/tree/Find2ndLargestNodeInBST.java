/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Find2ndLargestNodeInBST.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find last but one node in BST
 *                    
 * All rights reserved.
 ******************************************************************************/
package tree;

import util.BinaryTreeNode;

public class Find2ndLargestNodeInBST {
    public BinaryTreeNode search2ndLarest(BinaryTreeNode root){
        BinaryTreeNode parent = null, largest = root;
        while(largest.right != null){
            parent = root;
            largest = largest.right;
        }
        if(largest.left != null){
            BinaryTreeNode leftMax = largest.left;
            while(leftMax.right != null){
                leftMax = leftMax.right;
            }
            return leftMax;
        }else{
            return parent;
        }
    }
}
