/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindMaxCommonSubTree.java
 *         Created:   9/23
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to find the maxmum common subtree in a tree(with multiple nodes)
 *                    (the id of each TreeNode does not matter, just the structure of the subtrees be the same).
 *                    we serialize each subtree into a unique string, and put the string into the hashmap
 *                    serialization is O(n) if we use pre-order. If we use level order to serialize each subtree, the TC would be O(n^2)
 *            
 * All rights reserved.
 ******************************************************************************/
package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import util.TreeNode;

public class FindMaxCommonSubTree {

    public static List<Integer> getLargestCommonSubtrees(TreeNode root) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        serialize(root, map);
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (Entry<String, ArrayList<Integer>> e : map.entrySet()) {
            if (e.getKey().length() >= max && e.getValue().size() > 1) {
                ans.addAll(e.getValue());
            }
        }
        return ans;
    }

    /**
     * serialize all subtree in O(n) 
     */
    private static String serialize(TreeNode root, HashMap<String, ArrayList<Integer>> map) {
        StringBuilder sig = new StringBuilder();
        sig.append(root.children.size());
        for (TreeNode child : root.children) {
            sig.append(serialize(child, map));
        }
        if (map.containsKey(sig.toString())) {
            map.get(sig.toString()).add(root.id);
        } else {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(root.id);
            map.put(sig.toString(), list);
        }
        return sig.toString();
    }
}
