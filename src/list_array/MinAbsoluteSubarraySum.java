/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MinAbsoluteSubarraySum.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a unsorted array, find minimum absolute value of subarray sum. 
 *                    |sum of subarray| = Math.min(min positive subarray sum, max negative subarray sum)
 *                    we cannot maintain min positive subarray sum in O(n)
 *                    so we use prefix sum to find it in Time O(nlogn)
 *                    Target = Math.min(prefix[i] - prefix[i + 1])
 *                    NOTE MeetQun
 * All rights reserved.
 ******************************************************************************/
package list_array;

import java.util.Arrays;

public class MinAbsoluteSubarraySum {
    public int findMinAbsoluteValue(int[] array) {
        int[] prefixSum = new int[array.length];
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = array[i] + prefixSum[i - 1];
        }
        Arrays.sort(prefixSum);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < prefixSum.length; i++) {
            if (prefixSum[i] - prefixSum[i - 1] < min) {
                min = prefixSum[i] - prefixSum[i - 1];
            }
        }
        return min;
    }
}
