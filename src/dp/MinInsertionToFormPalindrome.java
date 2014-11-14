/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaxGapSequenceSum.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 *                    Let the input string be str[l...h]. The problem can be broken down into three parts:
 *                    1. Find the minimum number of insertions in the substring str[l+1,...h].
 *                    2. Find the minimum number of insertions in the substring str[l...h-1].
*                     3. Find the minimum number of insertions in the substring str[l+1...h-1].
 * All rights reserved.
 ******************************************************************************/
package dp;

public class MinInsertionToFormPalindrome {
    public int findMinInsertionDP(char[] str){
        int[][] dp = new int[str.length][str.length];
        for(int len = 2; len <= str.length; len++){
            for(int i = 0; i <= str.length - len; i++){
                int j = i + len - 1;
                if(str[i] == str[j]){
                    dp[i][j] = Math.min(dp[i + 1][j - 1], Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1));
                }else{
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i + 1][j] + 1);
                }
            }
        }
        return dp[0][str.length - 1];
    }
    
    public static void main(String[] args) {
        char[] str = "geeks".toCharArray();
        MinInsertionToFormPalindrome test = new MinInsertionToFormPalindrome();
        System.out.println(test.findMinInsertionDP(str));
    }
}
