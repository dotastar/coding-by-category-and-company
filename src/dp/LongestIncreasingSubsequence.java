/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestIncreasingSubsequence.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Implment LIS in DP(O(n^2))
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int list(int[] data){
        int[] dp = new int[data.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i <data.length; i++){
            for(int j = 0; j < i; j++){
                if(data[i] > data[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
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
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        System.out.println(test.list(arr));
    }
}
