/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DynamicFindMedian.java
 *         Created:   10/12
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Numbers are randomly generated and passed to a method.
 *                    Write a program to find and maintain the median value as new values are generated.
 *            
 * All rights reserved.
 ******************************************************************************/
package stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DynamicFindMedian {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public DynamicFindMedian() {
        minHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        });
    }

    public void insert(int value) {
        if (maxHeap.isEmpty() || value < maxHeap.peek()) {
            maxHeap.add(value);
        } else {
            minHeap.add(value);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            int mov = maxHeap.poll();
            minHeap.add(mov);
        }
        if (minHeap.size() > maxHeap.size() + 1) {
            int mov = minHeap.poll();
            maxHeap.add(mov);
        }
    }

    public int getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty())
            return Integer.MIN_VALUE;
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }

    public static void main(String[] args) {
        DynamicFindMedian test = new DynamicFindMedian();
        int[] data = new int[] { 0, 3, 4, 1, 2, 4, 3, 5, 6, 7 };
        for (int i = 0; i < data.length; i++) {
            test.insert(data[i]);
        }
        System.out.println(test.getMedian());
    }
}
