/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckPointInTriangle.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Check whether a given point lies inside a triangle or not 
 *                    Refer: http://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
 * All rights reserved.
 ******************************************************************************/
package geometric;

import java.awt.Point;

public class CheckPointInTriangle {
    //using 2D vector determinant
    public float area(Point et1, Point et2, Point et3) {
        return (float) Math.abs((et1.x * (et2.y - et3.y) + et2.x * (et3.y - et1.y) + et3.x * (et1.y - et2.y)) / 2.0);
    }
    
    public boolean isInside(Point[] triangle, Point p){
        float A = area(triangle[0], triangle[1], triangle[2]);
        float A1 = area(p, triangle[1], triangle[2]);
        float A2 = area(triangle[0], p, triangle[2]);
        float A3 = area(triangle[0], triangle[1], p);
        return A == (A1 + A2 + A3);
    }
}
