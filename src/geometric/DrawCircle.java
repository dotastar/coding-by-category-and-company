/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DrawCircle.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a radius of a circle, draw the circle without using floating point arithmetic.
 *                    Consider a square of size (2r+1)*(2r+1) around the circle to be drawn.
 *                    Now walk through every point inside the square.
 *                    For every every point (x,y), if (x, y) lies inside the circle (or x^2+ y^2 < r^2), then print it, otherwise print space.
 * All rights reserved.
 ******************************************************************************/
package geometric;

public class DrawCircle {
    void drawCircle(int r) {
        int N = 2 * r + 1; // Consider a rectangle of size N*N
        int x = 0, y = 0; // Coordinates inside the rectangle
        // Draw a square of size N*N.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                x = i - r;// Start from the left most corner point
                y = j - r;
                if (x * x + y * y <= r * r) {
                    System.out.println(x + " " + y);
                }
            }
        }
    }
}
