/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MultiplyWith7.java
 *         Created:   Nov 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to multiply by 7 in Time Complexity O(1)
 *                    
 * All rights reserved.
 ******************************************************************************/
package number;

public class MultiplyWith7 {
    public int multiplyBySeven(int n) {
        return ((n << 3) - n);
    }
}
