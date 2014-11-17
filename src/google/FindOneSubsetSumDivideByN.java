/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindOneSubsetSumDivideByN.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an arraylist of N integers, find a non-empty subset whose sum is a multiple of N.  
 *                    O(n^2) solution. Basically for each number that is 0 to N-1,
 *                    we want to keep track of which subsets of the input will add up to that number after modulo N. 
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindOneSubsetSumDivideByN {
    public List<Integer> findSubset(int[] data, int N) {
        HashMap<Integer, LinkedList<Integer>> subsets = new HashMap<Integer, LinkedList<Integer>>();
        subsets.put(0, new LinkedList<Integer>());
        for (int ele : data) {
            HashSet<Integer> keys = new HashSet<Integer>(subsets.keySet());
            for (int remainder : keys) {
                int sum = (remainder + ele) % N;
                if (sum == 0) {
                    subsets.get(remainder).add(ele);
                    return subsets.get(remainder);
                }
                if (subsets.containsKey(sum)) {
                    continue;
                }
                LinkedList<Integer> list = new LinkedList<Integer>(subsets.get(remainder));
                list.add(ele);
                subsets.put(sum, list);
            }
        }
        return null;
    }
}
