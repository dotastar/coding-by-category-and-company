/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TrailingZerosInFactorial.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5.
 *                    If we can count the number of 5s and 2s, our task is done. 
 *                    We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. So if we count 5s in prime factors, we are done.   
 *                    For example, 7! has one 5, 10! has two 5s. It is done yet, there is one more thing to consider. Numbers like 25, 125, etc have more than one 5. 
 *                    Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ....
 *                    
 * All rights reserved.
 ******************************************************************************/
package number;

public class TrailingZerosInFactorial {
    public int findTrailingZeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
