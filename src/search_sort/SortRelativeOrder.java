/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SortRelativeOrder.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   sort an array by relative position
 *                    Give a array which has negative and positive integers,
 *                    implement a algorithm that costs O(nlogn) time and O(1) spaces to make all negative integers in front of all positive integers
 *                    Our algorithm is just like divide and conquer method.
 *                    each iteration we detect {+,+...+, -, -, ..., -} to make range switch {-,-,-..+,+} in O(n)
 *                    there is total logn iterations
 * All rights reserved.
 ******************************************************************************/
package search_sort;

public class SortRelativeOrder {
    public int[] sortArray(int[] array) {
        boolean set = true;
        while (set) {
            set = false;
            int i = 0, posiIdx = -1, negaIdx = -1;
            for (; i < array.length; i++) {
                if (array[i] >= 0) {
                    if (posiIdx != -1 && negaIdx != -1) {
                        rotate(array, posiIdx, negaIdx, i - 1);
                        set = true;
                    }
                    posiIdx = i;
                    negaIdx = -1;
                } else {
                    negaIdx = negaIdx == -1 ? i : negaIdx;
                }
            }
            if (posiIdx != -1 && negaIdx != -1) {
                rotate(array, posiIdx, negaIdx, i - 1);
                set = true;
            }
        }
        return array;
    }

    //range switch make {a1, a2, ..am, b1,b2..bn} to {b1,b2,..bn,a1,a2..am}
    public void rotate(int[] array, int posiIdx, int negaIdx, int end) {
        reverse(array, posiIdx, negaIdx - 1);
        reverse(array, negaIdx, end);
        reverse(array, posiIdx, end);
    }

    public void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        SortRelativeOrder test = new SortRelativeOrder();
        int[] data = test.sortArray(new int[] { 1, -1, 2, -2, -4, 3, 5, -7, 8, 9, 10, -11, -23, 0 });
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
