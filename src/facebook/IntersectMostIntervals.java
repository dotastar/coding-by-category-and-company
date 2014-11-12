/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   IntersectMostIntervals.java
 *         Created:   Nov 11, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   giving lots of intervals [ai, bi], find a point intersect with the most number of intervals 
 *                    if find, we output the number of intersect.
 *                    This problem equals with find optimal room count for N meetings([start_time, end_time])
 * All rights reserved.
 ******************************************************************************/
package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.Interval;

public class IntersectMostIntervals {
    public class Bound implements Comparable<Bound> {
        public int key;
        public boolean isStart;

        public Bound(int key, boolean isStart) {
            this.key = key;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Bound o) {
            if (this.key == o.key) {
                return this.isStart == true ? -1 : 1;
            }
            return this.key - o.key;
        }
    }

    public int search(List<Interval> ints) {
        ArrayList<Bound> data = new ArrayList<Bound>();
        for (Interval iter : ints) {
            data.add(new Bound(iter.start, true));
            data.add(new Bound(iter.end, false));
        }
        Collections.sort(data);
        int maxCount = 0, curCount = 0;
        for (Bound iter : data) {
            if (iter.isStart) {
                curCount++;
            } else {
                curCount--;
            }
            maxCount = Math.max(maxCount, curCount);
        }
        return maxCount;
    }
    
    public static void main(String[] args) {
        ArrayList<Interval> data = new ArrayList<Interval>();
        data.add(new Interval(1, 2));
        data.add(new Interval(3, 4));
        data.add(new Interval(5, 6));
        IntersectMostIntervals test = new IntersectMostIntervals();
        System.out.println(test.search(data));
    }
}
