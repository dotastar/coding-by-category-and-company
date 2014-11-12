/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SearchRepeatingAndMissingPositiveNum.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an unsorted array of size n.
 *                    Array elements are in range from 1 to n.
 *                    One number from set {1, 2, ...n} is missing and one number occurs twice in array. Find these two numbers.
 *                    Refer: http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 * All rights reserved.
 ******************************************************************************/
package list_array;

public class SearchRepeatingAndMissingPositiveNum {
    public void getTwoElements(int[] array){
        int xor = 0;
        for(int i = 0; i < array.length; i++){
            xor = xor ^ array[i];
        }
        for(int i = 1; i <= array.length; i++){
            xor = xor ^ i;
        }
        int diffBit = xor ^ (-xor);
        int x = 0, y = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & diffBit) == 0){
                x = x ^ array[i];
            }else{
                y = y ^ array[i];
            }
        }
        for(int i = 1; i < array.length; i++){
            if((i & diffBit) == 0){
                x = x ^ i;
            }else{
                y = y ^ i;
            }
        }
        System.out.println("x:" + x + " y:" + y);
    }
}
