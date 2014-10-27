/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LargestIndependentSet.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a Binary Tree, find size of the Largest Independent Set(LIS) in it. 
 *                    A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset.
 *                    Let LISS(X) indicates size of largest independent set of a tree with root X.
 *                    LISS(X) = MAX { (1 + sum of LISS for all grandchildren of X), (sum of LISS for all children of X) }
 *                    http://www.geeksforgeeks.org/largest-independent-set-problem/
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.HashMap;

import util.BinaryTreeNode;

public class LargestIndependentSet {
    public int findIndependentSet(BinaryTreeNode root) {
        return search(root, new HashMap<BinaryTreeNode, Integer>());
    }

    public int search(BinaryTreeNode root, HashMap<BinaryTreeNode, Integer> map) {//dp: map_cache
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int exclude = search(root.left, map) + search(root.right, map);
        int include = 1;
        include += (root.left != null ? search(root.left.left, map) + search(root.left.right, map) : 0);
        include += (root.right != null ? search(root.right.left, map) + search(root.right.right, map) : 0);
        map.put(root, Math.max(include, exclude));
        return map.get(root);
    }
}
