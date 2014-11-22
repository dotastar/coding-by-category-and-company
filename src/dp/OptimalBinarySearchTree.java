/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   OptimalBinarySearchTree.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts,
 *                    where freq[i] is the number of searches to keys[i].
 *                    Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
 *                    keys[] = {10, 12}, freq[] = {34, 50}
 *                    10           12
 *                      \          /
 *                        12      10
 *                    The cost of tree I is 34*1 + 50*2 = 134
 *                    The cost of tree II is 50*1 + 34*2 = 118
 *                    OptCost(i, j) = [Sum(freqs(k)): i <= k <= j] + Min{optCost(i, r - 1) + optCost(r + 1, j) : i<= r <= j}
 * All rights reserved.
 ******************************************************************************/
package dp;

public class OptimalBinarySearchTree {
    public int optCost(int[] keys, int[] freqs, int N) {
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            cost[i][i] = freqs[i];
        }
        for (int l = 1; l < N; l++) {
            for (int i = 0; i < N - l; i++) {
                int j = i + l;
                cost[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int c = (k > i ? cost[i][k - 1] : 0) + (k < j ? cost[k + 1][j] : 0) + sum(freqs, i, j);
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }
        return cost[0][N - 1];
    }

    public int sum(int[] freqs, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += freqs[k];
        }
        return s;
    }

    public static void main(String[] args) {
        OptimalBinarySearchTree test = new OptimalBinarySearchTree();
        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        System.out.println(test.optCost(keys, freq, 3));
    }
}
