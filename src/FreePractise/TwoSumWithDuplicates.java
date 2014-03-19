/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TwoSumWithDuplicates.java
 *         Version:   1.0
 *         Created:   3/1 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given a fixed number, find the number of pairs in array, which can satisfy this condition;
 *                    eg. 1, 1, 1, 4, 4, 4; the sum is 5; so the #ofPairs is 9 (consider the duplicates)
 *            
 * All rights reserved.
 ******************************************************************************/
package freepractise;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumWithDuplicates {

    /**
     * this solution come from ChangJian, which use hashmap but don't scan it
     * the key is use: Distributive law of multiplication!!!!
     * this solution's advantage is determine the order when forming to pair (eg. {3,3,3,3} given 6)
     * 
     * @param src
     * @param target
     * @return
     */
    public static int twoSum1(int[] src, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = 0; i < src.length; i++) {
            if (map.containsKey(target - src[i])) {
                ans += map.get(target - src[i]);
            }
            if (map.containsKey(src[i])) {
                map.put(src[i], map.get(src[i]) + 1);
            } else {
                map.put(src[i], 1);
            }
        }
        return ans;
    }

    /**
     * this solution is use sorting which need the O(1) space
     * also use Distributive law of multiplication!!!!
     * 
     * @param src
     * @param target
     * @return
     */
    public static int twoSum2(int[] src, int target) {
        Arrays.sort(src);
        int left = 0, right = src.length - 1;
        int ans = 0;
        while (left < right) {
            if (src[left] + src[right] < target) {
                left++;
            } else if (src[left] + src[right] > target) {
                right--;
            } else {
                int oriPos = right;
                for (; right > left; right--) {
                    ans++;
                }
                right = oriPos;
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test = { 3, 3, 3, 3 };
        System.out.println(TwoSumWithDuplicates.twoSum1(test, 6));
        System.out.println(TwoSumWithDuplicates.twoSum2(test, 6));
    }
}
