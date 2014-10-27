/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   NumOfBinaryWithConsecutive1s.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1's.
 *                    Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1's and which end in 0.
 *                    let b[i] be the number of such strings which end in 1. 
 *                    a[i] = a[i - 1] + b[i - 1]
 *                     b[i] = a[i - 1]
 * All rights reserved.
 ******************************************************************************/
package dp;

public class NumOfBinaryWithConsecutive1s {
    public int countStrins(int N) {
        int[] ending0 = new int[N + 1], ending1 = new int[N + 1];
        ending0[1] = ending1[1] = 1;
        for (int i = 2; i <= N; i++) {
            ending0[i] = ending0[i - 1] + ending1[i - 1];
            ending1[i] = ending0[i - 1];
        }
        return ending0[N] + ending1[N];
    }

    public static void main(String[] args) {
        NumOfBinaryWithConsecutive1s test = new NumOfBinaryWithConsecutive1s();
        System.out.println(test.countStrins(3));
    }
}
