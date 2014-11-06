/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckNumDivisibleBy7.java
 *         Created:   Nov 4, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Divisibility by 7 can be checked by a recursive method.
 *                    A number of the form 10a + b is divisible by 7 if and only if a - 2b is divisible by 7.
 *                    In other words, subtract twice the last digit from the number formed by the remaining digits.
 *                    Refer: http://www.geeksforgeeks.org/divisibility-by-7/
 * All rights reserved.
 ******************************************************************************/
package number;

public class CheckNumDivisibleBy7 {
    public boolean isDivisibleBy7(int num) {
        if (num < 0) {
            return isDivisibleBy7(-num);
        }
        if (num == 0 || num == 7) {
            return true;
        }
        if (num < 10) {
            return false;
        }
        return isDivisibleBy7(num / 10 - 2 * (num - num / 10 * 10));//eg. ab, check a - 2b can be divisible by 7
    }
}
