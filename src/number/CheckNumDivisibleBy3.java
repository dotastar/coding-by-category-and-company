/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckNumDivisibleBy3.java
 *         Created:   Nov 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to check if a Number is Multiple of 3
 *                    There is a pattern in binary representation of the number that can be used to find if number is a multiple of 3.
 *                    If difference between count of odd set bits (Bits set at odd positions) and even set bits is multiple of 3 then is the number.
 *                    Time Complexity is O(logn)
 *                    Proof Refer: http://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
 * All rights reserved.
 ******************************************************************************/
package number;

public class CheckNumDivisibleBy3 {
    public boolean isMultipleOf3(int n) {
        int oddCnt = 0, evenCnt = 0;
        n = Math.abs(n);
        if (n == 1) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                oddCnt++;
            }
            n = n >> 1;
            if ((n & 1) == 1) {
                evenCnt++;
            }
            n = n >> 1;
        }
        return isMultipleOf3(Math.abs(oddCnt - evenCnt));
    }
    
    public static void main(String[] args) {
        CheckNumDivisibleBy3 test = new CheckNumDivisibleBy3();
        System.out.println(test.isMultipleOf3(33));
    }
}
