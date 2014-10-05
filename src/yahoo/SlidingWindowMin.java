/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SlidingWindowMin.java
 *         Created:   Oct 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array of integer, find the minimum in the sliding window of size 4, in most optimal way. 
 *                    eg. Input: [2,1,3,4,6,3,8,9,10,12,56]  Output: [1,1,3,3,3,3,8,9]
 *                    TC: O(n)
 * All rights reserved.
 ******************************************************************************/
package yahoo;

public class SlidingWindowMin {
    public static int[] getMin(int[] data, int k) {
        int[] minLeft = new int[data.length], minRight = new int[data.length];
        minLeft[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            minLeft[i] = i % k == 0 ? data[i] : Math.min(minLeft[i - 1], data[i]);
        }
        minRight[data.length - 1] = data[data.length - 1];
        for (int i = data.length - 2; i >= 0; i--) {
            minRight[i] = (i + 1) % k == 0 ? data[i] : Math.min(data[i], minRight[i + 1]);
        }
        int[] ans = new int[data.length - k + 1];
        for (int i = 0, j = 0; i + k <= data.length; i++) {
            ans[j++] = Math.min(minRight[i], minLeft[i + k - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = { 2, 1, 3, 4, 6, 3, 8, 9, 10, 12, 56 };
        int[] ans = getMin(data, 4);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
