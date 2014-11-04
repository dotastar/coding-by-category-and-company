/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   NumsWithoutDigit3.java
 *         Created:   Nov 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a number n, write a function that returns count of numbers from 0 to n
 *                    that don't contain digit 3 in their decimal representation.
 *                    its very easy to do using basic permutations, eg.578:
 *                    1.let first digit be 0,1,2,4, then other 2 can be any except 3:
 *                    2.let first digit be 5(set at its max value); and second be 1,2,4,5,6;third any except 3: 
 *                    3.let first digit be 5(set at its max. value) and second be 7(set at its max value), then third can vary only up to 8(except 3 again):
 * All rights reserved.
 ******************************************************************************/
package number;

import java.util.ArrayList;

public class NumsWithoutDigit3 {
    public int countNumsWithoutDigit3(int n) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        while (n > 0) {
            data.add(0, n % 10);
            n = n / 10;
        }
        int ans = 0, len = data.size(), last = len - 1;
        for (int i = 0; i < len - 1; i++) {
            if (data.get(i) <= 3) {
                ans += (data.get(i)) * (int) Math.pow(9, (len - 1 - i));
                if (data.get(i) == 3) {//NOTE
                    return ans;
                }
            } else {
                ans += (data.get(i) - 1) * (int) Math.pow(9, (len - 1 - i));
            }
        }
        ans += data.get(last) >= 3 ? data.get(last) : data.get(last) + 1;
        return ans;
    }

    public static void main(String[] args) {
        NumsWithoutDigit3 test = new NumsWithoutDigit3();
        System.out.println(test.countNumsWithoutDigit3(578));
    }
}
