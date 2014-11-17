/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FixedMinVariationSubset.java
 *         Created:   Nov 15, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given a array, find k numbers to make these k numbers' variance minimum. 
 *                    NOTE 1. sort the array first.
 *                    2. use a sliding window to traverse this array.
 *                    (x1-k)^2+(x2-k)^2+.......+(xm-k)^2 
 *                    = x1^2 + x2^2 + .... xm^2 + m*k^2 - 2k*(x1 + x2 + ..... xm), k is average of m numbers
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.Arrays;

public class FixedMinVarianceSubset {
    public int findMinVarianceSubset(int[] data, int k) {
        Arrays.sort(data);
        int curSum = 0, squareSum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            curSum += data[i];
            squareSum += (int) Math.pow(data[i], 2);
        }
        min = squareSum + k * (int) Math.pow((int) (curSum / k), 2) - 2 * ((int) (curSum / k)) * (curSum);
        for (int i = k; i < data.length; i++) {
            curSum = curSum + data[i] - data[i - k];
            squareSum = squareSum + (int) Math.pow(data[i], 2) - (int) Math.pow(data[i - k], 2);
            int variance = squareSum + k * (int) Math.pow((int) (curSum / k), 2) - 2 * ((int) (curSum / k)) * (curSum);
            min = Math.min(min, variance);
        }
        return min;
    }
}
