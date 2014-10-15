/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   KthFromKSortedArray.java
 *         Version:   1.0
 *         Created:   9/18 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to find kth of k sorted array, my solution has O(k) tc
 *            
 * All rights reserved.
 ******************************************************************************/
package list_array;

import java.util.ArrayList;

public class KthFromKSortedArray {
    private class Pos {
        public int s;
        public int e;

        public Pos(int start, int end) {
            this.s = start;
            this.e = end;
        }
    }

    public int findKth(ArrayList<ArrayList<Integer>> data, int k) {//k start from 0
        ArrayList<Pos> p = new ArrayList<Pos>();
        for (int i = 0; i < data.size(); i++) {
            Pos cur = new Pos(0, data.get(i).size() - 1);
            p.add(cur);
        }
        return find(data, p, k);
    }

    private int find(ArrayList<ArrayList<Integer>> data, ArrayList<Pos> p, int k) {
        if (data.size() == 1) {//if only 1 array is left, then we can directly locate kth 
            return data.get(0).get(p.get(0).s + k);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minPos = -1, maxPos = -1;
        for (int i = 0; i < data.size(); i++) {
            int len = p.get(i).e - p.get(i).s + 1;
            if (data.get(i).get(p.get(i).s + len / 2) < min) {
                minPos = i;
            }
            if (data.get(i).get(p.get(i).s + len / 2) > max) {
                maxPos = i;
            }
        }
        int totalFirstHalf = 0;//a/2 + b/2 + c/2......
        for (int i = 0; i < data.size(); i++) {
            totalFirstHalf += (p.get(i).e - p.get(i).s + 1) / 2;
        }
        if (k > totalFirstHalf) {//remove first half(include mid) of the array in which the minimum mid is
            int minLen = p.get(minPos).e - p.get(minPos).s + 1;
            p.get(minPos).s = (p.get(minPos).s + minLen / 2) + 1;
            if (p.get(minPos).s > p.get(minPos).e) {
                data.remove(minPos);
                p.remove(minPos);
            }
            return find(data, p, k - (minLen / 2 + 1));
        } else {//remove last half(include mid) of the array in which the maximum mid is
            int maxLen = p.get(maxPos).e - p.get(maxPos).s + 1;
            p.get(maxPos).e = (p.get(minPos).s + maxLen / 2) - 1;
            if (p.get(maxPos).s > p.get(maxPos).e) {
                data.remove(maxPos);
                p.remove(maxPos);
            }
            return find(data, p, k);
        }
    }
}
