/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestCommonSubsequence.java
 *         Created:   Sep 22, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   http://www.ics.uci.edu/~eppstein/161/960229.html
 *                    
 * All rights reserved.
 ******************************************************************************/
package strings;

import java.util.ArrayList;

public class LongestCommonSubsequence {
    public ArrayList<Character> find(char[] a, char[] b) {
        ArrayList<Character> path = new ArrayList<Character>();
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {//i means first i chars
            for (int j = 1; j <= b.length; j++) {//j means first j chars
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = a.length, j = b.length;
        while (i > 0 && j > 0) {
            if (a[i - 1] == b[j - 1]) {
                path.add(0, a[i - 1]);
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return path;

    }

    public static void main(String[] args) {
        LongestCommonSubsequence test = new LongestCommonSubsequence();
        char[] a = { 'A', 'B', 'C', 'D', 'G', 'H' };
        char[] b = { 'A', 'E', 'D', 'F', 'H', 'R' };
        System.out.println(test.find(a, b));
        char[] c = { 'A', 'G', 'G', 'T', 'A', 'B' };
        char[] d = { 'G', 'X', 'T', 'X', 'A', 'Y', 'B' };
        System.out.println(test.find(c, d));
    }
}
