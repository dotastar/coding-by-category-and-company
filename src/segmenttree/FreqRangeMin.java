/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SegmentTree.java
 *         Created:   Oct 21, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   (1). how to search Min for range[i, j] in a array frequently.
 *                    (2). The elements in a range[k, m] can be added to some value in this array frequently.
 *                    see http://www.cnblogs.com/TenosDoIt/p/3453089.html 
 *                    Summary:
 *                    Given a array, this array can be operated in three options below:
 *                    1. add a specific value to a specific range in this array.
 *                    2. set a specific value to a specific range in this array.
 *                    3. query the Min/Max/Sum for a specific range in this array.
 *                    So how to get the results from 3, after doing 1/2 operations multiple times
 * All rights reserved.
 ******************************************************************************/
package segmenttree;

import util.SegNode;

public class FreqRangeMin {
    SegNode[] tree;

    public FreqRangeMin(int[] data) {
        //we set the tree to a full binary tree, which number of nodes is 2^(log2(n)(upbound) + 1) - 1
        tree = new SegNode[(int) Math.pow(2, 1 + 1 + (int) (Math.log(data.length) / Math.log(2))) - 1];
        build(0, data, 0, data.length - 1);
    }

    public void build(int root, int data[], int s, int e) {
        if (s == e) {
            tree[root].val = data[s];
            return;
        }
        int mid = (s + e) / 2;
        build(root * 2 + 1, data, s, mid);
        build(root * 2 + 2, data, mid + 1, e);
        tree[root].val = Math.min(tree[root * 2 + 1].val, tree[root * 2 + 2].val);
    }

    public int query(int root, int ns, int ne, int qs, int qe) {
        if (qs > ne || qe < ns) {
            return Integer.MAX_VALUE;
        }
        if (qs <= ns && qe >= ne) {
            return tree[root].val;
        }
        pushDown(root);
        int mid = (ns + ne) / 2;
        return Math.min(query(root * 2 + 1, ns, mid, qs, qe), query(root * 2 + 2, mid + 1, ne, qs, qe));
    }

    public void update(int root, int ns, int ne, int us, int ue, int addVal) {
        if (us > ne || ue < ns) {
            return;
        }
        if (us <= ns && ue >= ne) {
            tree[root].addMark += addVal;
            tree[root].val += addVal;
            return;
        }
        pushDown(root);
        int mid = (ns + ne) / 2;
        update(root * 2 + 1, ns, mid, us, ue, addVal);
        update(root * 2 + 2, mid + 1, ne, us, ue, addVal);
        tree[root].val = Math.min(tree[root * 2 + 1].val, tree[root * 2 + 2].val);
    }

    public void pushDown(int root) {
        if (tree[root].addMark != 0) {
            tree[root * 2 + 1].addMark += tree[root].addMark;
            tree[root * 2 + 2].addMark += tree[root].addMark;
            tree[root * 2 + 1].val += tree[root].addMark;
            tree[root * 2 + 2].val += tree[root].addMark;
            tree[root].addMark = 0;
        }
    }
}
