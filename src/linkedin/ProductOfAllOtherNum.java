/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ProductOfAllOtherNum.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32655311.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

public class ProductOfAllOtherNum {
    public int[] product(int[] input) {
        int[] output = new int[input.length];
        int p = 1;
        for (int i = 0; i < input.length; i++) {
            output[i] = p;
            p *= input[i];
        }
        p = 1;
        for (int i = input.length - 1; i >= 0; i--) {
            output[i] *= p;
            p *= input[i];
        }
        return output;
    }
}
