/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BoundedWorkable.java
 *         Created:   Oct 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Whether a pack can be filled up with bounded items(Numi <= Mi)    
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

public class BoundedWorkable {
    
    /**
     * Basic Formula: dp[i, j] = true or false; O(N * V * (V/ci))
     *                dp[i, j] = dp[i - 1, j] || dp[i - 1, j - ci] || ... || dp[i - 1, j - k * ci], k = Min(amount, V/ci)
     *                           ------------    ------------------------------------------------------------------------
     *                            first_part                            second_part
     * We redefine the sub_problem: dp[i, j] = the max number of remaining ith item if we could use first i type of items to fill up the volume j, or -1 if it cannot be filled up
     * the max number of remaining ith, is for the latter dp usage
     * By redefine the sub_problem, we apply the dp[i][j] to the dp formula, and decrease the time complexity to O(N*V)
     */
    public boolean workable(int V, int N, int[] cost, int[] amount) {
        int[][] dp = new int[N + 1][V + 1];
        for (int j = 1; j <= V; j++) {//NOTE init
            dp[0][j] = -1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (dp[i - 1][j] >= 0) {//first part
                    dp[i][j] = amount[i - 1];
                } else if (j >= cost[i - 1] && dp[i][j - cost[i - 1]] > 0){//second part
                    dp[i][j] = dp[i][j - cost[i - 1]] - 1;
                }else{
                    dp[i][j] = -1;
                }
            }
        }
        return dp[N][V] >= 0 ? true : false;
    }
}
