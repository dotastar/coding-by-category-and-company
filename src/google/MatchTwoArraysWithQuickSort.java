/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MatchTwoArraysWithQuickSort.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array of object A, and an array of object B. All A's have different sizes, and all B's have different sizes. Any object A is of the 
 *                    same size as exactly one object B. We have a function f(A, B) to compare the size of one A and one B. But we cannot compare between two A's or two B's.
 *                    Give an algorithm to match each A with each B.
 *                    Solution to this problem is with help of quicksort. 
 *                    1. pick any object A randomly, then compare it all B to find the exact match for it. This pivot in quicksort.
 *                    2. While searching for match divide B into two part with respect to pivot so this will make 
 *                       all small object (of type B) than pivot on left side and all large object (of type B ) on right.. same as quicksort.
 *                    3. So at this point we find exact match for B as well as we aligend B. Now we can do the same thing on array of object A . Then repeat the process for on both halves. 
                          
 * All rights reserved.
 ******************************************************************************/
package google;

public class MatchTwoArraysWithQuickSort {
    public void match(int[] A, int[] B, int s, int e) {
        if (s >= e) {
            return;
        }
        int pivot = partition(B, A[s], s, e);
        partition(A, B[pivot], s, e);
        match(A, B, s, pivot - 1);
        match(A, B, pivot + 1, e);
    }

    public int partition(int[] data, int mid, int s, int e) {
        int i = s, j = e, idx = -1;
        while (i <= j) {
            if (compare(data[i], mid) < 0) {
                i++;
                continue;
            }
            if (compare(data[j], mid) >= 0) {
                idx = data[j] == mid ? j : idx;//NOTE
                j--;
                continue;
            }
            swap(data, i, j);
            idx = data[j] == mid ? j : idx;//NOTE
        }
        swap(data, i, idx);
        return i;
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //API
    public int compare(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        MatchTwoArraysWithQuickSort test = new MatchTwoArraysWithQuickSort();
        int[] A = new int[] { 5, 6, 4, 1, 8, 0 };
        int[] B = new int[] { 4, 1, 8, 6, 5, 0 };
        test.match(A, B, 0, A.length - 1);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }
}
