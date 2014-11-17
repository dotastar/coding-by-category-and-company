/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   InfixCombination.java
 *         Created:   6/3
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a int array, and a target number, check whether the combination of array
 *                    can equal to the value of target number using +, -, *, /
 *                    Here I just give the recursive solution. My DP idea is listed in Gist 
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

import java.util.HashSet;

public class InfixCombination {

    //Recursive Way, the time complexity is exponential due to the increment of return set size
    public boolean check(int[] input, int target) {
        HashSet<Integer> set = combine(input, 0, input.length - 1);
        for (Integer iter : set) {
            if (iter == target) {
                return true;
            }
        }
        return false;
    }

    private HashSet<Integer> combine(int[] input, int start, int end) {
        HashSet<Integer> res = new HashSet<Integer>();
        if (start == end) {
            res.add(input[start]);
            return res;
        }
        for (int i = start; i < end; i++) {
            HashSet<Integer> leftSet = combine(input, start, i);
            HashSet<Integer> rightSet = combine(input, i + 1, end);
            for (Integer left : leftSet) {
                for (Integer right : rightSet) {
                    assembly(res, left, right);
                }
            }
        }
        return res;
    }

    private void assembly(HashSet<Integer> set, int left, int right) {
        set.add(left + right);
        set.add(left - right);
        set.add(left * right);
        if (right != 0)
            set.add(left / right);
    }

    public static void main(String[] args) {
        InfixCombination test = new InfixCombination();
        System.out.println(test.check(new int[] { 3, 2 }, 6));
    }
}
