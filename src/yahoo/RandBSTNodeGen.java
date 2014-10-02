/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RandBSTNodeGen.java
 *         Created:   6/8 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Step1. traverse this BST to get the size N
 *                    Step2. generate a random number within N, kth.
 *                    Step3. find kth node in BST in logn
 *                    http://stackoverflow.com/questions/2329171/find-kth-smallest-element-in-a-binary-search-tree-in-optimum-way/2329236#2329236
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

import util.RankNode;

public class RandBSTNodeGen {

    public RankNode generate(RankNode root, int kth) {//kth must be less than N - 1(size)
        if (kth < root.leftSize) {
            return generate(root.left, kth);
        } else if (kth == root.leftSize) {
            return root;
        } else {
            return generate(root.right, kth - (root.leftSize + 1));
        }
    }

    public RankNode insert(RankNode root, int val) {
        if (root == null) {
            return new RankNode(val);
        }
        if (val <= root.val) {
            root.left = insert(root.left, val);
            root.leftSize++;
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

}
