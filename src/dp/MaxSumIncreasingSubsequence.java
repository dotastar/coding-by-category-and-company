/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaxSumIncreasingSubsequence.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Write a program to find the sum of maximum sum subsequence of the given array
 *                    such that the intgers in the subsequence are sorted in increasing order.
 *                    if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100) 
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {
    public int list(int[] data){
        int[] dp = new int[data.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i <data.length; i++){
            for(int j = 0; j < i; j++){
                if(data[i] > data[j] && dp[i] < dp[j] + data[i]){
                    dp[i] = dp[j] + data[i];
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i  = 0; i < data.length; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = { 1, 101, 2, 3, 100, 4, 5};
        MaxSumIncreasingSubsequence test = new MaxSumIncreasingSubsequence();
        System.out.println(test.list(arr));
    }
}
