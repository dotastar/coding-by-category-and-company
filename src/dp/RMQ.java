/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RMQ.java
 *         Created:   Nov 10, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Range Minimum/Maximum Query
 *                    Given an array, we need perform bunch of queries to find Max/Min in (i, j)
 *                    We can preprocess array in Time(nlogn), and when doing searching, each query need logn time
 *                    Refer: http://blog.csdn.net/niushuai666/article/details/6624672
 * All rights reserved.
 ******************************************************************************/
package dp;

public class RMQ {
    private int logn;
    private int n;
    private int[][] maxSum;
    private int[][] minSum;

    public RMQ(int[] array) {
        n = array.length;
        logn = (int) (Math.log(n) / Math.log(2)) + 1;//NOTE log2(n)
        maxSum = new int[n][logn];
        minSum = new int[n][logn];
        for (int i = 0; i < n; i++) {
            minSum[i][0] = maxSum[i][0] = array[i];
        }
    }

    public void preprocess() {//preprocess in Time O(nlogn)
        for (int j = 1; j <= logn; j++) {
            for (int i = 0; i < n; i++) {
                if (i + (1 << j) - 1 < n) {
                    maxSum[i][j] = Math.max(maxSum[i][j - 1], maxSum[i + (1 << (j - 1))][j - 1]);
                    minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i + (1 << (j - 1))][j - 1]);
                }
            }
        }
    }

    public int searchMax(int i, int j) {
        if (i < 0 || j >= n) {
            return -1;
        }
        int k = (int) (Math.log(j - i + 1) / Math.log(2));//NOTE find max scale k which can be coved by [i, j]
        return Math.max(maxSum[i][k], maxSum[j - (1 << k) + 1][k]);//NOTE find(5,6,7,8,9) = max(find(5,6,7,8), find(6,7,8,9))
    }

    public static void main(String[] args) {
        RMQ test = new RMQ(new int[] { 3, 4, 5, 6, 7, 8, 8 });
        test.preprocess();
        System.out.println(test.searchMax(0, 4));
    }
}
