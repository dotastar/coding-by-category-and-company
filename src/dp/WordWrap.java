/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   WordWrap.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a sequence of words, and a limit on the number of characters that can be put in one line.
 *                    Put line breaks in the given sequence such that the lines are printed neatly.
 *                    Optimized Problem:
 *                    Cost of a line = (number of extra spaces in this line)^2
 *                    Total Cost = Sum of costs for all lines
 *                    The value extras[i][j] indicates the cost to put words from i to j in a single line where i and j are indexes of words in the input sequences
 *                    extras[i][j] = -1, means a sequence of words from i to j cannot fit in a single line.
 *                    C[i] is the optimized total cost for first i words
 *                    C[i] =  0, if i = 0;
 *                         =  Min(C[j] + extras[j][i - 1]*extras[j][i - 1]), if extras[j][i - 1] != -1, for 0 <= j < i
 *                    http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 *                    http://en.wikipedia.org/wiki/Word_wrap
 * All rights reserved.
 ******************************************************************************/
package dp;

public class WordWrap {
    public int solveWordWrap(int[] wordLen, int width) {
        int[][] extras = new int[wordLen.length][wordLen.length];
        int[] cost = new int[wordLen.length + 1];
        for (int i = 0; i < wordLen.length; i++) {
            extras[i][i] = width - wordLen[i];
            for (int j = i + 1; j < wordLen.length; j++) {
                int extra = extras[i][j - 1] - wordLen[i] - 1;
                extras[i][j] = extra > 0 ? extra : -1;
            }
        }
        for (int i = 1; i <= wordLen.length; i++) {
            cost[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if ((extras[j][i - 1] != -1) && (extras[j][i - 1] * extras[j][i - 1] + cost[j] < cost[i])) {
                    cost[i] = extras[j][i - 1] * extras[j][i - 1] + cost[j];
                }
            }
        }
        return cost[wordLen.length];
    }


    public static void main(String[] args) {
        WordWrap test = new WordWrap();
        System.out.println(test.solveWordWrap(new int[] { 3, 2, 2, 5 }, 6));
    }
}
