/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PrimeFactorsOfGivenNumber.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a number n, write an efficient function to print all prime factors of n.
 *                    http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 *                    After we removing all 2 prime factors, all remaining prime factors must be odd.
 *                    this explains why i is incremented by 2.
 * All rights reserved.
 ******************************************************************************/
package number;

import java.util.ArrayList;

public class PrimeFactorsOfGivenNumber {
    public ArrayList<Integer> primeFactors(int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (n % 2 == 0) {
            ans.add(2);
            n = n / 2;
        }
        for (int i = 3; i <= n; i = i + 2) {//NOTE
            while (n % i == 0) {
                ans.add(i);
                n = n / i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PrimeFactorsOfGivenNumber test = new PrimeFactorsOfGivenNumber();
        System.out.println(test.primeFactors(315));
    }
}
