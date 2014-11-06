/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MultipyWithMultiplicationOperator.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given two integers, write a function to multiply them without using multiplication operator. 
 *                    
 * All rights reserved.
 ******************************************************************************/
package number;

public class MultiplyWithoutMultiplyOperator {
    public int multiply(int a, int b) {
        int res = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res += a;
            }
            a = a << 1;
            b = b >> 1;
        }
        return res;
    }
}
