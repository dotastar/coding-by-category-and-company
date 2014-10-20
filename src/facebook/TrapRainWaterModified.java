/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TrapRainWaterModified.java
 *         Created:   Oct 20, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   This problem is same as Trapping Rain Water.
 *                    The only difference is "0" means leak water 
 *                    
 * All rights reserved.
 ******************************************************************************/
package facebook;

public class TrapRainWaterModified {
    public int trap(int[] A) {
        int highest = 0, ans = 0, leftTop = 0, rightTop = A.length - 1, locWater = 0;
        for (int i = 1; i < A.length; i++) {
            highest = A[i] > A[highest] ? i : highest;
        }
        boolean leak = false;
        for (int i = 1; i < highest; i++) {
            if (A[i] == 0) {
                leak = true;
            }
            if (A[i] < A[leftTop]) {
                locWater += A[leftTop] - A[i];
            } else {
                leftTop = i;
                ans += leak ? 0 : locWater;
                leak = false;
                locWater = 0;
            }
        }
        ans += leak ? 0 : locWater;
        leak = false;
        locWater = 0;
        for (int i = A.length - 2; i > highest; i--) {
            if (A[i] == 0) {
                leak = true;
            }
            if (A[i] < A[rightTop]) {
                locWater += A[rightTop] - A[i];
            } else {
                rightTop = i;
                ans += leak ? 0 : locWater;
                leak = false;
                locWater = 0;
            }
        }
        ans += leak ? 0 : locWater;
        return ans;
    }

    public static void main(String[] args) {
        TrapRainWaterModified test = new TrapRainWaterModified();
        System.out.println(test.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 3, 2, 1 }));
    }
}
