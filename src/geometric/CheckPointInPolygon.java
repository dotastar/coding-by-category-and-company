/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckPointInPolygon.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to check if a given point lies inside or outside a polygon?
 *                    Refer: http://www.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon/
 * All rights reserved.
 ******************************************************************************/
package geometric;

import util.Point;

public class CheckPointInPolygon {
    public boolean isInside(Point[] polygon, Point p) {
        if (polygon.length < 3) {
            return false;
        }
        Point extreme = new Point(Integer.MAX_VALUE, p.y);
        int count = 0, i = 0;
        do {
            int next = (i + 1) % polygon.length;
            if (Check2SegmentsIntersect.doIntersect(polygon[i], polygon[next], p, extreme)) {
                if (Check2SegmentsIntersect.orientation(polygon[i], p, polygon[next]) == 0) {
                    return Check2SegmentsIntersect.onSegment(polygon[i], p, polygon[next]);
                }
                count++;
            }
            i = next;
        } while (i != 0);
        return count % 2 != 0;
    }

    public static void main(String[] args) {
        Point[] data = { new Point(0, 0), new Point(10, 0), new Point(10, 10), new Point(0, 10) };
        CheckPointInPolygon test = new CheckPointInPolygon();
        System.out.println(test.isInside(data, new Point(20, 20)));
    }
}
