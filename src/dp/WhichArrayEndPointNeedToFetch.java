/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   WhichArrayEndPointNeedToFetch.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a array and two players, each player can only pick two end-points for array[i, j] in turn.
 *                    If sum of all elements player1 picks is larger than sum of all elements player2 picks, player1 wins
 *                    we need write a function to determine max sum for array[i, j] of player1
 *                    we define dp[i][j]  = max sum of array[i,j] for player1
 *                    Refer: evernote_MeetQun
 * All rights reserved.
 ******************************************************************************/
package dp;

public class WhichArrayEndPointNeedToFetch {
    public int computeMaxSum(int[] array) {
        int[][] dp = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i][i] = array[i];
        }
        for (int i = 0; i < array.length - 1; i++) {
            dp[i][i + 1] = array[i] > array[i + 1] ? array[i] : array[i + 1];
        }
        for (int len = 3; len <= array.length; len++) {
            for (int i = 0; i <= array.length - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(array[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        array[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
            }
        }
        return dp[0][array.length - 1];
    }
}
