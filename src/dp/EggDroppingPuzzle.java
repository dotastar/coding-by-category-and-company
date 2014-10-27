/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   EggDroppingPuzzle.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given N eggs and K floors, how to find minimum number of droppings needed in worst case
 *                    k ==> Number of floors
 *                    n ==> Number of Eggs
 *                    eggDrop(n, k) ==> Minimum number of trails needed to find the critical floor in worst case.
 *                    eggDrop(n, k) = 1 + min{max(eggDrop(n - 1, x - 1), eggDrop(n, k - x)): x in {1, 2, ..., k}}
 * All rights reserved.
 ******************************************************************************/
package dp;

public class EggDroppingPuzzle {
    public int eggDrop(int N, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int n = 1; n <= N; n++) {
            dp[n][1] = 1;
        }
        for (int k = 1; k <= K; k++) {
            dp[1][k] = k;//NOTE worst case
        }
        for (int n = 2; n <= N; n++) {
            for (int k = 2; k <= K; k++) {
                dp[n][k] = Integer.MAX_VALUE;
                for (int x = 1; x <= k; x++) {
                    //minimum droppings in worst case, so we take max for the two cases.
                    dp[n][k] = Math.min(dp[n][k], 1 + Math.max(dp[n - 1][x - 1], dp[n][k - x]));
                }
            }
        }
        return dp[N][K];
    }
    public static void main(String[] args) {
        EggDroppingPuzzle test = new EggDroppingPuzzle();
        System.out.println(test.eggDrop(2, 36));
    }
}
