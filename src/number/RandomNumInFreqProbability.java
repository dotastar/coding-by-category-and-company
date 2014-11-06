/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RandomNumInFreqProbability.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given n numbers, each with some frequency of occurrence.
 *                    Return a random number with probability proportional to its frequency of occurrence.
 *                    1. Take an auxiliary array (say prefix[]) of size n.
 *                    2.  Populate it with prefix sum, such that prefix[i] represents sum of numbers from 0 to i.
 *                    3.  Generate a random number(say r) between 1 to Sum(including both), where Sum represents summation of input frequency array.
 *                    4.  Find index of Ceil of random number generated in step #3 in the prefix array. Let the index be indexc.
 *                    Refer: http://www.geeksforgeeks.org/fundamentals-of-algorithms/
 * All rights reserved.
 ******************************************************************************/
package number;

public class RandomNumInFreqProbability {
    public int frequencyRandomGenerator(int[] array, int[] freq, int len) {
        int[] prefix = new int[len];
        prefix[0] = freq[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        int r = 1 + (int) (Math.random() * (prefix[len - 1] - 1 + 1));//generate from 1 to prefix[len - 1] randomly
        int idx = findCeil(prefix, r);
        return array[idx];
    }

    public int findCeil(int[] prefix, int r) {
        int l = 0, h = prefix.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (prefix[mid] == r) {
                return mid;
            } else if (prefix[mid] > r) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    public static void main(String[] args) {
        int arr[]  = {1, 2, 3, 4};
        int freq[] = {10, 5, 20, 100};
        RandomNumInFreqProbability test = new RandomNumInFreqProbability();
        System.out.println(test.frequencyRandomGenerator(arr, freq, 4));
    }
}
