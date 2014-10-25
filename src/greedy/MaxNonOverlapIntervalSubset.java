/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MaxNonOverlapIntervalSubset.java
 *         Created:   Oct 20, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a set of intervals, find a maximum subset so that no 2 intervals overlap 
 *                    Greedy algorithm instead of dp, think why?
 *                    The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the start time is more than the finish time of previously selected activity.
 *                    We can sort the activities according to their finishing time so that we always consider the next activity as minimum finishing time activity.
 * All rights reserved.
 ******************************************************************************/
package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import util.Interval;

public class MaxNonOverlapIntervalSubset {
    public ArrayList<Interval> find(List<Interval> ints) {
        Collections.sort(ints, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) {
                    return o1.start - o1.start;
                }
                return o1.end - o2.end;
            }
        });
        ArrayList<Interval> ans = new ArrayList<Interval>();
        ans.add(ints.get(0));
        for (int i = 1; i < ints.size(); i++) {
            if (ints.get(i).start > ans.get(ans.size() - 1).end) {
                ans.add(ints.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Interval> data = new ArrayList<Interval>();
        data.add(new Interval(1, 2));
        data.add(new Interval(0, 6));
        data.add(new Interval(3, 4));
        data.add(new Interval(5, 7));
        data.add(new Interval(8, 9));
        data.add(new Interval(5, 9));
        MaxNonOverlapIntervalSubset test = new MaxNonOverlapIntervalSubset();
        System.out.println(test.find(data));
    }
}
