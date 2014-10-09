/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LISWithOrder.java
 *         Created:   Sep 22, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   CTCI 11.7 we use DP(aka. 2nd solution) to solve it! tc is around O(n^2)
 *                    please see http://www.felix021.com/blog/read.php?1587
 *                    this problem is to find subsequence, so we cannot sort them at first!
 *                    
 * All rights reserved.
 ******************************************************************************/
package strings;

import java.util.ArrayList;

public class LISWithOrder {
    public static class HtWt implements Comparable<HtWt> {
        private int Ht;
        private int Wt;

        public HtWt(int h, int w) {
            this.Ht = h;
            this.Wt = w;
        }

        @Override
        public int compareTo(HtWt o) {
            HtWt second = (HtWt) o;
            if (this.Ht != second.Ht) {
                return this.Ht - second.Ht;
            } else {
                return this.Wt - second.Wt;
            }
        }

        public boolean isBefore(HtWt other) {
            if (this.Ht < other.Ht && this.Wt < other.Wt) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static ArrayList<HtWt> search(ArrayList<HtWt> array) {
        ArrayList<HtWt>[] cache = new ArrayList[array.size()];
        for (int i = 0; i < array.size(); i++) {
            HtWt cur = array.get(i);
            ArrayList<HtWt> prevBestSeq = null;
            for (int j = 0; j < i; j++) {
                if (array.get(j).isBefore(cur)) {
                    prevBestSeq = seqWithMaxLength(prevBestSeq, cache[j]);
                }
            }
            ArrayList<HtWt> curRes = new ArrayList<HtWt>();
            if (prevBestSeq != null) {
                curRes.addAll(prevBestSeq);
            }
            curRes.add(cur);
            cache[i] = curRes;
        }
        ArrayList<HtWt> ans = null;
        for (int i = 0; i < array.size(); i++) {
            ans = seqWithMaxLength(ans, cache[i]);
        }

        return ans;
    }

    private static ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
        if (seq1 == null) {
            return seq2;
        } else if (seq2 == null) {
            return seq1;
        }
        return seq1.size() > seq2.size() ? seq1 : seq2;
    }
}
