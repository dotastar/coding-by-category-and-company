/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SubArrayWithGivenSum.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 *                    
 * All rights reserved.
 ******************************************************************************/
package list_array;

public class SubArrayWithGivenSum {
    public boolean subArraySum(int[] array, int sum){
        int curSum = 0, start = 0, end = 0;
        for(; end < array.length; end++){
            curSum += array[end];
            while(curSum > sum && start < end){
                curSum = curSum - array[start];
                start++;
            }
            if(curSum == sum){
                System.out.println(start + "-" + end);
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SubArrayWithGivenSum test = new SubArrayWithGivenSum();
        System.out.println(test.subArraySum(new int[]{15, 2, 4, 8, 9, 5, 10, 23}, 23));
    }
}
