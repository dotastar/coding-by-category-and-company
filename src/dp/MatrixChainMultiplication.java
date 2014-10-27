/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MatrixChainMultiplication.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   We have many options to multiply a chain of matrices because matrix multiplication is associative.
 *                    (ABC)D = (AB)(CD) = A(BCD) = ....
 *                    However, the order in which we parenthesize the product affects the number of simple arithmetic operations needed to compute the product.
 *                    For example, suppose A is a 10 * 30 matrix, B is a 30 * 5 matrix, and C is a 5 * 60 matrix.
 *                    (AB)C = (10*30*5) + (10*5*60) = 1500 + 3000 = 4500 operations
 *                    A(BC) = (30*5*60) + (10*30*60) = 9000 + 18000 = 27000 operations.
 *                    http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
 * All rights reserved.
 ******************************************************************************/
package dp;

public class MatrixChainMultiplication {
    /*
     * Given an array p[] which represents the chain of matrixes
     * such that the ith matrix Ai is of dimension p[i] x p[i + 1].
     * Time Complexity is O(n^3) 
     */
    public int searchOrder(int[] data, int len){//len: the number of matrix
        int[][] dp = new int[len][len];
        for(int l = 1; l < len; l++){//l means the Ai .... Ai + l
            for(int i = 0; i < len - l; i++){
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + data[i] * data[k + 1] * data[j + 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
    
    public static void main(String[] args) {
        MatrixChainMultiplication test = new MatrixChainMultiplication();
        int[] data =new int[]{10, 20, 30};
        System.out.println(test.searchOrder(data, 2));
    }
}
