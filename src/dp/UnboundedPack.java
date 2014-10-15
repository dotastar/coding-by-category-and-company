/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   UnboundedPack.java
 *         Created:   Oct 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find out the maximum value subset of val[] such that sum of the costs of this subset is smaller than or equal to V.
 *                    You cannot break an item, either don't pick it, or pick it multiple times (0 <= kCi <= V).
 *                    The total num of sub-problem still is V*N. But solving dp(i, j) need O(V/Ci) time instead of O(1) 
 *                    One Option is solve this problem in ZeroOne Knapsack way.
 * All rights reserved.
 ******************************************************************************/
package dp;

public class UnboundedPack {

    //Time Complexity: O(N*V*(V/Ci))
    public int search1(int V, int N, int[] cost, int[] value) {
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 0; k * cost[i - 1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * cost[i - 1]] + k * value[i - 1]);
                }
            }
        }
        return dp[N][V];
    }

    /**
     * F(i, v) = Max{F(i-1, v), Max{F(i-1, V-Ci)+Wi, F(i-1, V-2Ci)+2Wi, .....}}
     *         = Max{F(i-1, v), F(i, V-Ci) + Wi}
     * Time Complexity: O(N*V)
     */
    public int search2(int V, int N, int[] cost, int[] value) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = cost[i - 1]; j <= V; j++) {
                dp[j] = Math.max(dp[j], dp[j - cost[i - 1]] + value[i - 1]);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        int V = 10, N = 4;
        int[] cost = { 6, 3, 4, 2 }, value = { 30, 14, 16, 9 };
        UnboundedPack test = new UnboundedPack();
        System.out.println(test.search1(V, N, cost, value));
    }
}
