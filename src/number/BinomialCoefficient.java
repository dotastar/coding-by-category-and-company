/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   BinomialCoefficient.java
 *         Created:   Nov 4, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   C(n, k) = n! / (n-k)! * k! = [n * (n-1) *....* 1]  / [ ( (n-k) * (n-k-1) * .... * 1) * ( k * (k-1) * .... * 1 ) ]
 *                    C(n, k) = [n * (n-1) * .... * (n-k+1)] / [k * (k-1) * .... * 1]
 *                    Time Complexity(O(k))
 * All rights reserved.
 ******************************************************************************/
package number;

public class BinomialCoefficient {
    public int binomialCoeff(int n, int k) {
        if (k > n - k) {
            k = n - k;//Since C(n, k) = C(n, n-k)
        }
        int res = 1;
        //Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1]
        for (int i = 0; i < k; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
