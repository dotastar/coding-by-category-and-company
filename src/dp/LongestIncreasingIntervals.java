/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LongestIncreasingIntervals.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   You are given n pairs of intervals.
 *                    A pair (c, d) can follow another pair (a, b) if b < c.
 *                    Chain of pairs can be formed in this fashion.
 *                    Find the longest chain which can be formed from a given set of pairs.
 *                    Time Complexity is O(n^2)
 * All rights reserved.
 ******************************************************************************/
package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Interval;

public class LongestIncreasingIntervals {
    public int findMaxChain(List<Interval> ints) {
        Collections.sort(ints, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) {
                    return o1.start - o1.start;
                }
                return o1.end - o2.end;
            }
        });
        int[] dp = new int[ints.size()];
        Arrays.fill(dp, 1);
        for (int i = 0; i < ints.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (ints.get(i).start > ints.get(j).end && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < ints.size(); i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingIntervals test = new LongestIncreasingIntervals();
        ArrayList<Interval> data = new ArrayList<Interval>();
        data.add(new Interval(5, 24));
        data.add(new Interval(15, 25));
        data.add(new Interval(27, 40));
        data.add(new Interval(50, 60));
        data.add(new Interval(8, 9));
        System.out.println(test.findMaxChain(data));
    }
}
