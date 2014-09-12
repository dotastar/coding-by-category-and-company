/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestIncreasingSubArray.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array = {1 2 3 3 2 4 6 7}, The longest increasing subarray is 2 4 6 7.
 *            
 * All rights reserved.
 ******************************************************************************/
package epic;

public class LongestIncreasingSubArray {

    public int[] getLongestIncreasingSubArray(int[] input) {
        int start = 0, end = 0, maxIdx = 0, max = Integer.MIN_VALUE;
        while (end + 1 < input.length) {
            if (input[end + 1] <= input[end]) {
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    maxIdx = start;
                }
                start = end + 1;
            }
            end++;
        }
        if (end - start + 1 > max) {
            max = end - start + 1;
            maxIdx = start;
        }
        int[] output = new int[max];
        System.arraycopy(input, maxIdx, output, 0, max);
        return output;
    }

    public static void main(String[] args) {
        LongestIncreasingSubArray test = new LongestIncreasingSubArray();
        int[] input = { 1, 2, 3, 3, 2, 4, 6, 7 };
        int[] output = test.getLongestIncreasingSubArray(input);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
        }
        System.out.println();
        int[] input2 = { 6, 2, 3, 4, 6, 5, 7, 8 };
        int[] output2 = test.getLongestIncreasingSubArray(input2);
        for (int i = 0; i < output2.length; i++) {
            System.out.print(output2[i]);
        }
    }
}
