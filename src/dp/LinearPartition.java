/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LinearPartition.java
 *         Created:   Oct 18, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a array, partition those numbers into K partitions such that sum of numbers in each partition is almost equal
 *                    it's not picking up subset, instead, we only need to divide the array into k regions
 *                    1 2 3 | 4 5 | 6
 *                    M(i, k) denotes the largest partition sum if using first i items to partition k retions
 *                    M(n, k) = min(max(M(i, k - 1), Sum(Sj)))  j = (i + 1, n) 
 *                    http://www8.cs.umu.se/kurser/TDBAfl/VT06/algorithms/BOOK/BOOK2/NODE45.HTM
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.ArrayList;

public class LinearPartition {
    public ArrayList<Integer> patition(int[] in, int k) {
        int[][] dp = new int[in.length + 1][k + 1];
        int[][] path = new int[in.length + 1][k + 1];
        int[] pSum = new int[in.length + 1];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i <= in.length; i++) {
            pSum[i] = pSum[i - 1] + in[i - 1];
        }
        for (int i = 1; i <= in.length; i++) {
            dp[i][1] = pSum[i];
        }
        for (int i = 2; i <= k; i++) {
            dp[1][k] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= in.length; i++) {
            for (int j = 2; j <= k; j++) {
                if (j > i) {
                    dp[i][j] = Integer.MAX_VALUE;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int x = 1; x < i; x++) {
                        if (min > Math.max(dp[x][j - 1], pSum[i] - pSum[x])) {
                            min = Math.max(dp[x][j - 1], pSum[i] - pSum[x]);
                            path[i][j] = x;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        int i = in.length, j = k;
        while (i > 0 && j > 0) {
            ans.add(0, path[i][j]);
            i = path[i][j];
            j--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        LinearPartition test = new LinearPartition();
        System.out.println(test.patition(data, 3));
    }
}
