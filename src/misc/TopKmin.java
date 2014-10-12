/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TopKmin.java
 *         Created:   10/8
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to find the top K minimum numbers from an array
 *            
 * All rights reserved.
 ******************************************************************************/
package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKmin {
    //TC: klog(n)
    public static ArrayList<Integer> solution1(int[] array, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }
        for (int i = 0; i < k; i++) {
            ans.add(heap.poll());
        }
        return ans;
    }

    //TC: nlog(k)
    public static ArrayList<Integer> solution2(int[] array, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });
        for (int i = 0; i < k; i++) {
            heap.add(array[i]);
        }
        for (int i = k; i < array.length; i++) {
            if (array[i] < heap.peek()) {
                heap.poll();
                heap.add(array[i]);
            }
        }
        Integer[] ans = heap.toArray(new Integer[heap.size()]);
        Arrays.sort(ans);
        return new ArrayList<Integer>(Arrays.asList(ans));
    }

    /**
     * quick selection, TC: average: O(n)
     */
    public static ArrayList<Integer> solution3(int[] data, int k) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        quickSelect(data, k, 0, data.length - 1, ans);
        return ans;
    }

    public static void quickSelect(int[] data, int k, int start, int end, ArrayList<Integer> ans) {
        if (start > end || k == 0) {
            return;
        }
        int pivot = partition(data, start, end);
        if (k >= pivot - start + 1) {
            for (int i = start; i <= pivot; i++) {
                ans.add(data[i]);
            }
            quickSelect(data, k - (pivot - start + 1), pivot + 1, end, ans);
        } else {
            quickSelect(data, k, start, pivot - 1, ans);
        }
    }

    public static int partition(int[] data, int start, int end) {
        int i = start + 1, j = end;
        while (i <= j) {
            if (data[i] < data[start]) {
                i++;
                continue;
            }
            if (data[j] >= data[start]) {
                j--;
                continue;
            }
            swap(data, i, j);
        }
        swap(data, start, j);
        return j;
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(TopKmin.solution3(new int[] { 3, 4, 2, 2, 2, 3, 4, 1, 1 }, 5));
    }
}
