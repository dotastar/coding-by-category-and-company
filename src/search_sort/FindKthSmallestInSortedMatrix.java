/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindKthSmallestInSortedMatrix.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a matrix, find kth smallest value in this matrix.
 *                    Each row and each col in this matrix are all sorted.
 *                    This problem can be equal with finding the kth smallest pair sum for two sorted lists
 * All rights reserved.
 ******************************************************************************/
package search_sort;

import java.util.HashSet;
import java.util.PriorityQueue;

public class FindKthSmallestInSortedMatrix {
    public class Element implements Comparable<Element> {
        public int idx;
        public int val;

        public Element(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.val, o.val);
        }
    }
    
    public int findKth(int[][] matrix, int k){
        if(matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int rows = matrix.length, cols = matrix[0].length;
        PriorityQueue<Element> heap = new PriorityQueue<Element>();
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        heap.add(new Element(0, matrix[0][0]));
        while(!heap.isEmpty()){
            Element cur = heap.poll();
            int row = cur.idx / rows, col = cur.idx % rows;
            if(k == 0){
                return cur.val;
            }
            k--;
            int idx = (row + 1) * rows + col;
            if(row + 1 < rows && !visited.contains(idx)){
                heap.add(new Element(idx, matrix[row + 1][col]));
                visited.add(idx);
            }
            idx = row * rows + col + 1;
            if(col + 1 < cols && !visited.contains(idx)){
                heap.add(new Element(idx, matrix[row][col + 1]));
                visited.add(idx);
            }
        }
        return-1;
    }
}
