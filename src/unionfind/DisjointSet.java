/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DisjointSet.java
 *         Created:   Oct 17, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   arr1 = {"A=B", "B=C", ...}, arr2 = {"A!=C", "F!=R", ...}
 *                    decide if there is conflict between above two arrays.(Yes!, A and C)
 *                    Time Compexity is M * logN (M: how many edges, N: how many nodes)
 * All rights reserved.
 ******************************************************************************/
package unionfind;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    boolean isConflict(String[] ss1, String[] ss2) {
        if (ss1 == null || ss2 == null) {
            return false;
        }
        Map<Character, Integer> idxMap = new HashMap<Character, Integer>();
        for (String s : ss1) {
            char c1 = s.charAt(0), c2 = s.charAt(2);
            if (!idxMap.containsKey(c1)) {
                idxMap.put(c1, idxMap.size());
            }
            if (!idxMap.containsKey(c2)) {
                idxMap.put(c2, idxMap.size());
            }
        }
        int[] set = new int[idxMap.size()];
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }
        for (String s : ss1) {
            char c1 = s.charAt(0), c2 = s.charAt(2);
            union(set, idxMap.get(c1), idxMap.get(c2));
        }
        for (String s : ss2) {
            char c1 = s.charAt(0), c2 = s.charAt(3);
            if (idxMap.containsKey(c1) && idxMap.containsKey(c2)) {
                int r1 = root(set, idxMap.get(c1)), r2 = root(set, idxMap.get(c2));
                if (r1 == r2) {
                    return true;
                }
            }
        }
        return false;
    }

    void union(int[] set, int i, int j) {
        int r1 = root(set, i), r2 = root(set, j);
        set[r1] = r2;
    }

    public int root(int[] set, int i) {
        while (i != set[i]) {
            set[i] = set[set[i]];//optimize
            i = set[i];
        }
        return i;
    }
}
