/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RandBSTNodeGen.java
 *         Version:   1.0
 *         Created:   6/8 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   This Code still have not been refactored!
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class RandBSTNodeGen {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public int leftNum;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node generate(Node root, int k) {
        if (k <= root.leftNum) {
            return generate(root.left, k);
        } else if (k == root.leftNum + 1) {
            return root;
        } else {
            return generate(root.right, k - (root.leftNum + 1));
        }
    }

    public void insert(Node root, int val) {
        if (val <= root.val) {
            root.leftNum++;
            if (root.left != null) {
                insert(root.left, val);
            } else {
                root.left = new Node(val);
            }
        } else {
            if (root.right != null) {
                insert(root.right, val);
            } else {
                root.right = new Node(val);
            }
        }
    }

}
