/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindLargestMultipleOf3.java
 *         Created:   Nov 4, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an array of non-negative integers. Find the largest multiple of 3 that can be formed from array elements.
 *                    Refer: http://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/
 *                    1) A number is multiple of 3 if and only if the sum of digits of number is multiple of 3. For example, let us consider 8760, it is a multiple of 3 because sum of digits is 8 + 7+ 6+ 0 = 21, which is a multiple of 3.
 *                    2) If a number is multiple of 3, then all permutations of it are also multiple of 3. For example, since 6078 is a multiple of 3, the numbers 8760, 7608, 7068, ... are also multiples of 3.
 *                    NOTE 3) We get the same remainder when we divide the number and sum of digits of the number. For example, if divide number 151 and sum of it digits 7, by 3, we get the same remainder 1.
 * All rights reserved.
 ******************************************************************************/
package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class FindLargestMultipleOf3 {
    public int findMaxMultipleOf3(int[] data) {
        Arrays.sort(data);
        LinkedList<Integer> queue0 = new LinkedList<Integer>();
        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        LinkedList<Integer> queue2 = new LinkedList<Integer>();
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (data[i] % 3 == 0) {
                queue0.add(data[i]);
            } else if (data[i] % 3 == 1) {
                queue1.add(data[i]);
            } else {
                queue2.add(data[i]);
            }
        }
        if (sum % 3 == 1) {
            if (!queue1.isEmpty()) {
                queue1.pollFirst();
            } else {
                queue2.pollFirst();
                queue2.pollFirst();
            }
        } else if (sum % 3 == 2) {
            if (!queue2.isEmpty()) {
                queue2.pollFirst();
            } else {
                queue1.pollFirst();
                queue1.pollFirst();
            }
        }
        ArrayList<Integer> aux = new ArrayList<Integer>();
        aux.addAll(queue0);
        aux.addAll(queue1);
        aux.addAll(queue2);
        int ans = 0;
        for (int i = aux.size() - 1; i >= 0; i--) {
            ans = ans * 10;
            ans += aux.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindLargestMultipleOf3 test = new FindLargestMultipleOf3();
        System.out.println(test.findMaxMultipleOf3(new int[] { 8, 1, 7, 6, 0 }));
    }
}
