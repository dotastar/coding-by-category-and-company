/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BoundedPack.java
 *         Created:   Oct 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Based on UnboundedPack problem, each item i has a upper bound amount, Mi.  
 *                    f[i][v] = max{f[i-1][v-k*c[i]]+k*w[i] | k=0, 1,..., min(V/c[i],M[i])}
 * All rights reserved.
 ******************************************************************************/
package dp;

public class BoundedPack {
    public static void zeroOnePack(int[] dp, int cost, int value, int V) {
        for (int j = V; j >= cost; j--) {
            dp[j] = Math.max(dp[j], dp[j - cost] + value);
        }
    }

    public static void unboundedPack(int[] dp, int cost, int value, int V) {
        for (int j = cost; j <= V; j++) {
            dp[j] = Math.max(dp[j], dp[j - cost] + value);
        }
    }

    //Time Complexity: O(V * Sum(log(Mi)))
    public static void boundedPack(int[] dp, int cost, int value, int V, int amount) {
        if (cost * amount >= V) {
            unboundedPack(dp, cost, value, V);
        } else {
            int k = 1;//NOTE convert it to zeroOnePack, split ith item into 1, 2, 2^2, ..., Mi - (2^k - 1), think why?(in case of exceed Mi)
            while (k < amount) {
                zeroOnePack(dp, k * cost, k * value, V);
                k = k * 2;
                amount = amount - k;
            }
            zeroOnePack(dp, amount * cost, amount * value, V);
        }
    }

    public static int boundedDriver(int V, int N, int[] cost, int[] value, int[] amount) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            boundedPack(dp, cost[i - 1], value[i - 1], V, amount[i - 1]);
        }
        return dp[V];
    }
    
}
