/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestBitonicSubsequence.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   a subsequence of arr[] is called Bitonic if it is first increasing, then decreasing.
 *                    Write a function that takes an array as argument and returns the length of the longest bitonic subsequence. 
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public int lbs(int[] data) {
        int[] lis = new int[data.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int[] lds = new int[data.length];
        Arrays.fill(lds, 1);
        for (int i = data.length - 2; i >= 0; i--) {
            for (int j = data.length - 1; j > i; j++) {
                if (data[i] > data[j] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        int ans = lis[0] + lds[0] - 1;
        for (int i = 1; i < data.length; i++) {
            if (lis[i] + lds[i] - 1 > ans) {
                ans = lis[i] + lds[i] - 1;
            }
        }
        return ans;
    }
}
