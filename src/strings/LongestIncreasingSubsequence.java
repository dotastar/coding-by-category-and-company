/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestIncreasingSubsequence.java
 *         Created:   Sep 22, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   This is 3rd solution O(nlogn), please see http://www.felix021.com/blog/read.php?1587
 *                    also check http://www.ahathinking.com/archives/117.html
 *                    
 * All rights reserved.
 ******************************************************************************/
package strings;

import java.util.ArrayList;

public class LongestIncreasingSubsequence {
    public ArrayList<Integer> find(int[] array) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        /*B[i]: the idx of smallest val being end with in LIS of size i. we start from 1!*/
        int[] B = new int[array.length + 1];
        //we use pred to backtrack the path
        int[] pred = new int[array.length];
        B[1] = 0;//init
        int curMaxLen = 1;
        for (int i = 1; i < array.length; i++) {
            int left = 1, right = curMaxLen;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[B[mid]] < array[i]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            B[left] = i;
            pred[i] = B[left - 1];
            if (left > curMaxLen) {
                curMaxLen++;
            }
        }
        int tail = B[curMaxLen];
        while (curMaxLen > 0) {
            ans.add(0, array[tail]);
            tail = pred[tail];
            curMaxLen--;
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        int[] data = { 2, 1, 5, 3, 6, 4, 8, 9, 7, 8, 9, 4 };
        System.out.println(test.find(data));
    }
}
