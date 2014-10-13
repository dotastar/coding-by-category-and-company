/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ReservoirSampling.java
 *         Created:   10/12
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to generate a k-elements buffer randomly from a stream 
 *            
 * All rights reserved.
 ******************************************************************************/
package stream;

public class ReservoirSampling {
    public static int[] solution(int[] array, int k) {
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = array[i];
        }
        for (int i = k; i < array.length; i++) {
            int pos = (int) Math.random() * (i - 0 + 1);
            if (pos < k) {
                ans[pos] = array[i];
            }
        }
        return ans;
    }
}
