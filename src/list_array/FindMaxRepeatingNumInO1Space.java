/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindMaxRepeatingNumInO1Space.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n.
 *                    Find the maximum repeating number in this array.
 *                    Expected time complexity is O(n) and extra space allowed is O(1). Modifications to array are allowed.
 * All rights reserved.
 ******************************************************************************/
package list_array;

public class FindMaxRepeatingNumInO1Space {

    /**
     * The array elements are in range from 0 to k-1
     * Since we use arr[i]%k as index and add value k at the index arr[i]%k,
     * the index which is equal to maximum repeating element will have the maximum value in the end.
     * Note that k is added maximum number of times at the index equal to maximum repeating element and all array elements are smaller than k.
     */
    public int maxRepeating(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            array[array[i] % k] += k;
        }
        int max = array[0], result = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                result = i;
            }
        }
        return result;
    }
}
