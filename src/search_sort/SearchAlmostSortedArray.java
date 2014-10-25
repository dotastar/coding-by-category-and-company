/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SearchAlmostSortedArray.java
 *         Created:   Oct 24, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions.
 *                    i.e., arr[i] may be present at arr[i+1] or arr[i-1]. 
 *                    consider the array {2, 3, 10, 4, 40}
 *                    So how to search a specific element in this array?
 * All rights reserved.
 ******************************************************************************/
package search_sort;

public class SearchAlmostSortedArray {
    public int binarySearch(int[] data, int target) {
        int l = 0, r = data.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (data[mid] == target) {
                return mid;
            }
            if (mid > l && data[mid - 1] == target) {
                return mid - 1;
            }
            if (mid < r && data[mid + 1] == target) {
                return mid + 1;
            }
            if (data[mid] > target) {
                r = mid - 2;
            } else {
                l = mid + 2;
            }
        }
        return -1;
    }
}
