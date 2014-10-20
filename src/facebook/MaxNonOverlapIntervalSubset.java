/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaxNonOverlapIntervalSubset.java
 *         Created:   Oct 20, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a set of intervals, find a maximum subset so that no 2 intervals overlap 
 *                    
 * All rights reserved.
 ******************************************************************************/
package facebook;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Interval;

public class MaxNonOverlapIntervalSubset {
    public int find(List<Interval> ints) {
        if (ints.size() == 0) {
            return 0;
        }
        Collections.sort(ints, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) {
                    return o1.start - o1.start;
                }
                return o1.end - o2.end;
            }
        });
        int[] dp = new int[ints.size() + 1];
        for (int i = 1; i <= ints.size(); i++) {
            int idx = binarySearch(ints.get(i - 1).start, ints);
            dp[i] = idx == -1 ? Math.max(1, dp[i - 1]) : Math.max(dp[idx + 1] + 1, dp[i - 1]);
        }
        return dp[ints.size()];
    }

    public int binarySearch(int point, List<Interval> ints) {
        int l = 0, r = ints.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((point >= ints.get(mid).start && point <= ints.get(mid).end) || (point < ints.get(mid).end)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
