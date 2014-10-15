/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   GroupPack.java
 *         Created:   Oct 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   there is K group, each group contains several items; every group is conflict with another.
 *                    at most one item can be taken out from each group to put into pack
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.ArrayList;

public class GroupZeroOnePack {
    public int search(int V, int K, ArrayList<ArrayList<Integer>> cost, ArrayList<ArrayList<Integer>> value) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= K; i++) {
            ArrayList<Integer> c = cost.get(i - 1), v = value.get(i - 1);
            for (int j = V; j > 0; j--) {
                int m = 0;
                for (int k = 0; k < c.size(); k++) {
                    if (c.get(k) > j) {
                        continue;
                    }
                    int tmp = Math.max(dp[j], dp[j - c.get(k)] + v.get(k));
                    m = Math.max(m, tmp);
                }
                dp[j] = m;
            }
        }
        return dp[V];
    }

}
