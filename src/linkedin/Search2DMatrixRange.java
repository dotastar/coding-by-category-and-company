/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Search2DMatrixRange.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32775405.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

public class Search2DMatrixRange {
    public void search2DRange(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return;
        }
        int[] ans = new int[2];
        int l = 0, u = matrix.length * matrix[0].length - 1;
        int idx = binarySearch(matrix, target, l, u, matrix[0].length);
        if (idx == -1) {
            return;
        } else {
            ans[0] = ans[1] = idx;
            while ((idx = binarySearch(matrix, target, l, idx - 1, matrix[0].length)) != -1) {
                ans[0] = idx;
            }
            idx = ans[1];
            while ((idx = binarySearch(matrix, target, idx + 1, u, matrix[0].length)) != -1) {
                ans[1] = idx;
            }
        }
        print(matrix, ans[0], ans[1], matrix[0].length);
    }

    public int binarySearch(int[][] matrix, int target, int l, int r, int m) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[mid / m][mid % m] == target) {
                return mid;
            } else if (matrix[mid / m][mid % m] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    
    public void print(int[][] matrix, int l, int u, int m) {
        for (int i = l; i <= u; i++) {
            System.out.print("(" + i / m + " " + i % m + ")" + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Search2DMatrixRange test = new Search2DMatrixRange();
        int[][] matrix = { { 1, 2, 4 }, { 4, 4, 4 }, { 4, 4, 4 }, { 4, 7, 8 } };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        test.search2DRange(matrix, 4);
    }
}
