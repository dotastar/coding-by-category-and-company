/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ZeroOnePack.java
 *         Created:   Oct 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find out the maximum value subset of val[] such that sum of the costs of this subset is smaller than or equal to V.
 *                    You cannot break an item, either pick the complete item, or don't pick it (0-1 property).
 *                    V must be contained in sub-problem for all type of pack problems(NOTE)
 *                    So we must consider V when derive sub-problem formula
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.ArrayList;

public class ZeroOnePack {

    /**
     * The Volume don't need to be filled up with packs.
     * So we initialize the first row and first col all to be 0!
     * Space Complexity: N*V
     */
    public int search1(int V, int N, int[] cost, int[] value) {
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= cost[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i - 1]] + value[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][V];
    }

    public ArrayList<Integer> print(int[][] dp, int V, int N, int[] cost, int[] value) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = N, j = V;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                ans.add(0, value[i - 1]);
                j = j - cost[i - 1];
            }
            i = i - 1;
        }
        return ans;
    }

    /**
     * The Volume don't need to be filled up with packs.
     * Space Complexity: V
     */
    public int search2(int V, int N, int[] cost, int[] value) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= cost[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i - 1]] + value[i - 1]);
            }
        }
        return dp[V];
    }

    /**
     * The Volume have to be filled up with packs.
     * NOTE think why this initialization is different with above methods
     * Space Complexity: V
     */
    public int search3(int V, int N, int[] c, int[] v) {
        int[] dp = new int[V + 1];
        dp[0] = 0;//NOTE v == 0, is a valid state, when there's no pack
        for (int j = 1; j <= V; j++) {
            dp[j] = Integer.MIN_VALUE;// v > 0, is not a valid state, when there's no pack 
        }
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= c[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i - 1]] == Integer.MIN_VALUE ? Integer.MIN_VALUE : dp[j - c[i - 1]]
                        + v[i - 1]);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        int V = 10, N = 4;
        int[] cost = { 5, 4, 6, 3 }, value = { 10, 40, 30, 50 };
        ZeroOnePack test = new ZeroOnePack();
        System.out.println(test.search1(V, N, cost, value));
    }
}
