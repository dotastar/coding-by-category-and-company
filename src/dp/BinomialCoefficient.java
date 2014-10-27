/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BinomialCoefficient.java
 *         Created:   Oct 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   C(n, k) = C(n-1, k-1) + C(n-1, k)
 *                    C(n, 0) = C(n, n) = 1
 *                    
 * All rights reserved.
 ******************************************************************************/
package dp;

public class BinomialCoefficient {
    public int binomialCoeff(int N, int K){
       int[][] dp = new int[N + 1][K + 1];
        for(int n = 0; n <= N; n++ ){
            dp[n][0] = 1;
        }
        for(int n = 1; n <= N; n++){
            for(int k = 1; k <= K; k++){
                dp[n][k] = dp[n - 1][k - 1] + dp[n - 1][k];
            }
        }
        return dp[N][K];
    }
    
    public static void main(String[] args) {
        BinomialCoefficient test = new BinomialCoefficient();
        System.out.println(test.binomialCoeff(5, 2));
    }
}
