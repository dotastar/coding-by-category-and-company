/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SubStrSumInPosArray.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   all integers in array are positive!, find subarray totalsum equal to target sum
 *                     
 *                    
 * All rights reserved.
 ******************************************************************************/
package epic;

public class SubStrSumInPosArray {
    public void subSum(int sum, int[] input) {
        if (input.length == 0) {
            return;
        }
        int start = 0, end = 0, curSum = 0;
        while (end < input.length) {
            curSum += input[end];
            if (curSum > sum) {
                while (start <= end && curSum > sum) {
                    curSum -= input[start];
                    start++;
                }
            }
            if (curSum == sum) {
                System.out.println("(" + start + " " + end + ")");
            }
            end++;
        }
    }

    public static void main(String[] args) {
        SubStrSumInPosArray test = new SubStrSumInPosArray();
        int[] input1 = { 7, 1, 7, 3, 1, 1, 2, 2 };
        test.subSum(5, input1);
    }
}
