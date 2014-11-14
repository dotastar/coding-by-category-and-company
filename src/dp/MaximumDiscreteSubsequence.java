/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaximumDiscreteSubsequence.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to find maximum(all elements sum) discrete subsequence 
 *                    NOTE this subsequence require each two elements can not be neighbor
 *                    [2,-3,3,50] -> 52
 * All rights reserved.
 ******************************************************************************/
package dp;

public class MaximumDiscreteSubsequence {
    public int searchMax(int[] data) {
        int[] dp = new int[data.length + 1];
        dp[1] = data[0] < 0 ? 0 : data[0];
        for (int i = 2; i <= data.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + data[i - 1]);
        }
        return dp[data.length];
    }

    public static void main(String[] args) {
        MaximumDiscreteSubsequence test = new MaximumDiscreteSubsequence();
        int[] data = new int[] { -1, 2, 5, -3, 7, 9, 15, 10, -5, -20, 30, 70, 50, -90 };
        System.out.println(test.searchMax(data));
    }
}
