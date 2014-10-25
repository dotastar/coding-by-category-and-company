/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SearchKclosest.java
 *         Created:   Oct 23, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a sorted array arr[] and a value X, find the k closest elements to X in arr[]. 
 *                    
 * All rights reserved.
 ******************************************************************************/
package search_sort;

import java.util.ArrayList;
import java.util.List;

public class SearchKclosest {
    /* find the crossover point (the point before which elements are smaller than or equal to target */
    public int searchCrossOver(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public List<Integer> findKclosest(int[] A, int target, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int l = searchCrossOver(A, target);
        int r = l + 1, count = 0;
        while (l >= 0 && r < A.length && count < k) {
            if (target - A[l] < A[r] - target) {
                ans.add(A[l--]);
            } else {
                ans.add(A[r++]);
            }
            count++;
        }
        for (; count < k && l >= 0; count++) {
            ans.add(A[l--]);
        }
        for (; count < k && r < A.length; count++) {
            ans.add(A[r++]);
        }
        return ans;
    }
}
