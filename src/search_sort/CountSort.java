/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CountSort.java
 *         Created:   Oct 23, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   O(n+k) where n is the number of elements in input array and k is the range of input.
 *                    Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted.
 *                    Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.
 *                    http://www.geeksforgeeks.org/counting-sort/
 * All rights reserved.
 ******************************************************************************/
package search_sort;

public class CountSort {
    public int[] countSort(int[] data) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] output = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            min = Math.min(min, data[i]);
            max = Math.max(max, data[i]);
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < data.length; i++) {
            count[data[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < data.length; i++) {
            output[count[data[i] - min] - 1] = data[i];
            count[data[i] - min]--;
        }
        return output;
    }

    public static void main(String[] args) {
        CountSort test = new CountSort();
        int[] output = test.countSort(new int[] { -3, -5, -6, 7, -1, 0, 8 });
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
