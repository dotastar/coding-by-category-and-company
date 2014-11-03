/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ConvexHull.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Convex Hull | Set 1 (Jarvis's Algorithm or Wrapping)
 *                    Given a set of points in the plane. the convex hull of the set is the smallest convex polygon that contains all the points of it.
 *                    http://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
 * All rights reserved.
 ******************************************************************************/
package geometric;

import java.util.ArrayList;

import util.Point;

public class ConvexHull {
    public ArrayList<Point> convexHull(Point[] points) {
        ArrayList<Point> ans = new ArrayList<Point>();
        if (points.length < 3) {
            return ans;
        }
        int leftMost = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < points[leftMost].x) {
                leftMost = i;
            }
        }
        int cur = leftMost, next = -1;
        do {
            next = (leftMost + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (Check2SegmentsIntersect.orientation(points[cur], points[i], points[next]) == 2) {//NOTE
                    next = i;
                }
            }
            ans.add(points[next]);
            cur = next;
        } while (cur != leftMost);
        return ans;
    }
}
