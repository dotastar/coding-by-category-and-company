/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SerializeTreeII.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an N-ary tree where every node has at-most N children.
 *                    In an N-ary tree, there are no designated left and right children.
 *                    An N-ary tree is represented by storing an array or list of child pointers with every node.
 *                    Refer: http://www.geeksforgeeks.org/serialize-deserialize-n-ary-tree/
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.LinkedList;

import util.TreeNode;

public class SerializeTreeII {

    private int N;

    public SerializeTreeII(int n) {
        this.N = n;
    }

    public void serialize(TreeNode root, LinkedList<Integer> stream) {
        if (root == null) {
            return;
        }
        stream.add(root.id);
        for (TreeNode child : root.children) {
            serialize(child, stream);
        }
        stream.add(null);//NOTE 'null' is a marker
    }

    public TreeNode deSerialize(LinkedList<Integer> stream) {
        if (stream.isEmpty() || stream.peekFirst() == null) {
            return null;
        }
        TreeNode root = new TreeNode(stream.pollFirst());
        for (int i = 0; i < N; i++) {
            TreeNode child = deSerialize(stream);
            if (child != null) {
                root.children.add(child);
            } else {
                break;
            }
        }
        return root;
    }

}
