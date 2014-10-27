/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaxSubSquareWithAll1s.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 *                    Dp[][] in which each entry Dp[i][j] represents size of the square sub-matrix with all 1s including data[i][j],
 *                    where data[i][j] is the right_bottom most point in sub-matrix.
 *                    
 * All rights reserved.
 ******************************************************************************/
package list_array;

public class MaxSubSquareWithAll1s {
    public void search(int[][] data) {
        int rows = data.length, cols = data[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            dp[i][0] = data[i][0];
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = data[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (data[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        int maxEdge = Integer.MIN_VALUE, x = -1, y = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maxEdge < dp[i][j]) {
                    maxEdge = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("bottom_right point: " + "(" + x + ", " + y + ")" + " edge_size: " + maxEdge);
    }

    public static void main(String[] args) {
        int[][] M =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        MaxSubSquareWithAll1s test = new MaxSubSquareWithAll1s();
        test.search(M);
    }
}
