/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RearrangePositiveAndNegative.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Rearrange positive and negative numbers in O(n) time and O(1) extra space
 *                    An array contains both positive and negative numbers in random order.
 *                    Rearrange the array elements so that positive and negative numbers are placed alternatively. 
 *                    Number of positive and negative numbers need not be equal.
 *                    Refer: http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 * All rights reserved.
 ******************************************************************************/
package search_sort;

public class RearrangePositiveAndNegative {
    public void rearrange(int[] array){
        int i = -1;
        //NOTE notice this partition method; 
        //The solution is to first separate positive and negative numbers using partition process of QuickSort.
        for(int j = 0; j < array.length; j++){
            if(array[j] < 0){
                swap(array, ++i, j);
            }
        }
        int posi = i + 1, neg = 0;
        while(posi < array.length && neg <= posi && array[neg] < 0){//NOTE
            swap(array, neg, posi);
            posi++;
        }
    }
    
    public void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
