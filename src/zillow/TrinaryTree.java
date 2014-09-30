/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TrinaryTree.java
 *         Created:   Sep 24, 2014 
 *          Author:   Nan Zhang 
 *            Note:   Implement insert and delete in tri-nary tree.
 *                    
 * All rights reserved.
 ******************************************************************************/
package zillow;

import java.io.IOException;
import junit.framework.Assert;

public class TrinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode mid = null;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int value) {
            this.val = value;
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            root.mid = root.mid == null ? new TreeNode(val) : insert(root.mid, val);
        } else if (root.val < val) {
            root.right = root.right == null ? new TreeNode(val) : insert(root.right, val);
        } else {
            root.left = root.left == null ? new TreeNode(val) : insert(root.left, val);
        }
        return root;
    }

    public static TreeNode delete(TreeNode root, int val) throws IOException {
        if (root == null) {
            throw new IOException("can't find the element to be removed!");
        }
        if (root.val < val) {
            root.right = delete(root.right, val);
        } else if (root.val > val) {
            root.left = delete(root.left, val);
        } else if (root.mid != null) {
            root.mid.left = root.left;
            root.mid.right = root.right;
            return root.mid;
        } else {
            //find min of right subtree, set it to new root, and update its parent.
            TreeNode min = root.right, minParent = null;
            while (min != null && min.left != null) {
                minParent = min;
                min = min.left;
            }
            if (min != null && minParent != null) {
                minParent.left = min.right;
                min.left = root.left;
                min.right = root.right;
            } else if (min != null && minParent == null) {
                min.left = root.left;
            }
            return min;
        }
        return root;
    }

    public static TreeNode testInsertion() throws IOException {
        int[] input = new int[] { 6, 5, 10, 6, 11, 3, 3 };
        TreeNode root = new TreeNode(input[0]);
        for (int i = 1; i < input.length; i++) {
            TrinaryTree.insert(root, input[i]);
        }
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        Assert.assertEquals("#33##5##66##10##11##", res.toString());
        return root;
    }

    public static void testDeletion(TreeNode root) throws IOException {
        root = delete(root, 6);
        root = delete(root, 6);
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        Assert.assertEquals("#33##5##10##11##", res.toString());
    }

    public static void serialize(TreeNode root, StringBuilder ans) {
        if (root == null) {
            ans.append("#");
            return;
        }
        serialize(root.left, ans);
        TreeNode mid = root;
        while (mid != null) {
            ans.append(String.valueOf(mid.val));
            mid = mid.mid;
        }
        ans.append("#");
        serialize(root.right, ans);
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = testInsertion();
        testDeletion(root);
        System.out.println("test complete!");
    }
}
