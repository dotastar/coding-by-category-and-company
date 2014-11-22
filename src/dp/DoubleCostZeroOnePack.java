/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DoubleCostPack.java
 *         Created:   Oct 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   each item has a double costs(cost1, cost2), and each item can only be put into pack once. 
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

public class DoubleCostZeroOnePack {
    public int search1(int V1, int V2, int N, int[] cost1, int[] cost2, int[] value) {
        int[][] dp = new int[V1 + 1][V2 + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V1; j >= cost1[i - 1]; j--) {
                for (int k = V2; k >= cost2[i - 1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - cost1[i - 1]][k - cost2[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[V1][V2];
    }

    /**
     * NOTE Given N items, each item can only be taken by at most once.
     * Given V, find exact k items from N items to fit in this V, and these K items have the maximum value sum.
     */
    public int search2(int V, int K, int N, int[] cost, int[] value) {
        int[][] dp = new int[K + 1][V + 1];
        for (int i = 1; i <= K; i++) {//NOTE think the init way
            for (int j = 0; j <= V; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int k = K; k >= 1; k--) {
                for (int j = V; j >= V - cost[i - 1]; j--) {
                    dp[k][j] = Math.max(dp[k][j], dp[k - 1][j - cost[i - 1]] == Integer.MIN_VALUE ? Integer.MIN_VALUE
                            : dp[k - 1][j - cost[i - 1]] + value[i - 1]);
                }
            }
        }
        return dp[K][V];
    }
}
