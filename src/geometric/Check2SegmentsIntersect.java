/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Check2SegmentsIntersect.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to check if two given line segments intersect?
 *                    Refer: http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
 *                    please check my evernote: Algorithm Analysis
 * All rights reserved.
 ******************************************************************************/
package geometric;

import util.Point;

public class Check2SegmentsIntersect {
    public static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);
        if (o1 != o2 && o3 != o4) {
            return true;
        }
        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }
        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }
        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }
        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }
        return false;
    }

    /**
     * | i, j | determinant
     * | r.x - q.x, r.y - q.y| first vector
     * | q.x - p.x, q.y - p.y| second vector
     * determinant: r = (r.x-q.x)*(q.y-p.y) - (q.x-p.x)*(r.y-q.y)
     * if r > 0, the angle rotated by counterclockwise from first vector to second vector
     * if r < 0, the angle rotated by clockwise from first vector to second vector
     * if r = 0, the two vector is colinear
     */
    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) {
            return 0;//0 --> p, q and r are colinear
        }
        return val > 0 ? 1 : 2;//1 --> Clockwise, 2 --> Counterclockwise
    }

    //Given three colinear points p, q, r, the function checks if point q lies on line segment 'pr'
    public static boolean onSegment(Point start, Point target, Point end) {
        if (target.x <= Math.max(start.x, end.x) && target.x >= Math.min(start.x, end.x)
                && target.y <= Math.max(start.y, end.y) && target.y >= Math.min(start.y, end.y)) {
            return true;
        }
        return false;
    }
}
