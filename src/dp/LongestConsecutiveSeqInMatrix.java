/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestConsecutiveSeqInMatrix.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given a matrix m * n, we put number from 1 ~ m*n  into the matrix randomly
 *                    find the longest consecutive increasing sequence in this matrix(we could traverse in four directions)
 *                    8 5 9
 *                    2 3 4
 *                    1 6 7
 *                    ans: 1,2,3,4 
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSeqInMatrix {
    public ArrayList<Integer> searchLCS(int[][] matrix) {
        int maxLen = Integer.MIN_VALUE;
        ArrayList<Integer> ans = null;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ArrayList<Integer> cur = search(matrix, i, j, new HashMap<Integer, ArrayList<Integer>>());
                if (cur.size() > maxLen) {
                    maxLen = cur.size();
                    ans = cur;
                }
            }
        }
        return ans;
    }

    public ArrayList<Integer> search(int[][] matrix, int i, int j, HashMap<Integer, ArrayList<Integer>> cache) {
        if (cache.containsKey(i * matrix.length + j)) {
            return cache.get(i * matrix.length + j);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(matrix[i][j]);
        ArrayList<Integer> neighborMax = null;
        neighborMax = searchNeighbor(matrix, matrix[i][j], i - 1, j, neighborMax, cache);
        neighborMax = searchNeighbor(matrix, matrix[i][j], i + 1, j, neighborMax, cache);
        neighborMax = searchNeighbor(matrix, matrix[i][j], i, j - 1, neighborMax, cache);
        neighborMax = searchNeighbor(matrix, matrix[i][j], i - 1, j + 1, neighborMax, cache);
        if (neighborMax != null) {
            ans.addAll(neighborMax);
        }
        cache.put(i + matrix.length + j, ans);
        return ans;
    }

    public ArrayList<Integer> searchNeighbor(int[][] matrix, int lastVal, int i, int j, ArrayList<Integer> nextMax,
            HashMap<Integer, ArrayList<Integer>> cache) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return nextMax;
        }
        if (lastVal + 1 == matrix[i][j]) {
            ArrayList<Integer> cur = search(matrix, i, j, cache);
            return nextMax == null || nextMax.size() < cur.size() ? cur : nextMax;
        }
        return nextMax;
    }
}
