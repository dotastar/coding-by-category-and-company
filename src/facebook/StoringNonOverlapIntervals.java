/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StoringNonOverlapIntervals.java
 *         Created:   Oct 19, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Implement a datastructure to store a bunch of non-overlap intervals [a, b]
 *                    it supports insert() and find()
 *                    
 * All rights reserved.
 ******************************************************************************/
package facebook;

import util.Interval;
import util.IntervalNode;

public class StoringNonOverlapIntervals {
    public IntervalNode root;
    public int minV;
    public int maxV;

    public boolean insert(Interval in) {
        if (root == null) {
            root = new IntervalNode(in);
            minV = in.start;
            maxV = in.end;
            return true;
        }
        IntervalNode iter = root, parent = null;
        while (iter != null) {
            parent = iter;
            if (in.start > iter.end) {
                iter = iter.right;
            } else if (in.end < iter.start) {
                iter = iter.left;
            } else {
                return false;
            }
        }
        if (in.start > parent.end) {
            parent.right = new IntervalNode(in);
        } else if (in.end < parent.start) {
            parent.left = new IntervalNode(in);
        }
        maxV = Math.max(in.end - 1, maxV);
        minV = Math.min(in.start, minV);
        return true;
    }

    Interval find(int point) {
        if (point < minV || point > maxV) {
            return null;
        }
        IntervalNode iter = root;
        while (iter != null) {
            if (point > iter.end) {
                iter = iter.right;
            } else if (point < iter.start) {
                iter = iter.left;
            } else {
                return new Interval(iter.start, iter.end);
            }
        }
        return null;
    }
}
