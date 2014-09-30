/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestCommonSubstring.java
 *         Created:   Sep 23, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   use DP http://blog.iderzheng.com/longest-common-substring-problem-optimization/
 *                    Time Complexity is O(nm)
 *                    
 * All rights reserved.
 ******************************************************************************/
package stringsequence;

public class LongestCommonSubstring {
    public String find(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            dp[i][0] = a.charAt(i) == b.charAt(0) ? 1 : 0;
        }
        for (int j = 0; j < b.length(); j++) {
            dp[0][j] = a.charAt(0) == b.charAt(j) ? 1 : 0;
        }
        for (int i = 0; i < a.length(); i++) {//i means the longest substr ending with ith
            for (int j = 0; j < b.length(); j++) {//j  means the longest substring ending with jth
                dp[i][j] = a.charAt(i) == b.charAt(j) ? 1 + dp[i - 1][j - 1] : 0; //we could optimize the space
            }
        }
        int maxIdx = -1, maxLen = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (maxLen < dp[i][j]) {
                    maxIdx = i - dp[i][j] + 1;
                    maxLen = dp[i][j];
                }
            }
        }
        return a.substring(maxIdx, maxIdx + maxLen);
    }

    public static void main(String[] args) {
        LongestCommonSubstring test = new LongestCommonSubstring();
        System.out.println(test.find("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
    }
}
