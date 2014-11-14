/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ThreeArraysMinDistance.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given three arrays A,B,C containing unsorted numbers.
 *                    Find three numbers a, b, c from each of array A, B, C such that |a-b|, |b-c| and |c-a| are minimum
 *                    
 * All rights reserved.
 ******************************************************************************/
package list_array;

import java.util.Arrays;

public class ThreeArraysMinDistance {
    public int minAbs(int[] a, int[] b, int[] c){
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int ia = 0, ib = 0, ic = 0, min = Integer.MAX_VALUE;
        while(ia < a.length && ib < b.length && ic < c.length){
            int cur = Math.abs(a[ia] - b[ib]) + Math.abs(a[ia] - c[ic]) + Math.abs(b[ib] - c[ic]);
            min = Math.min(min, cur);
            if(a[ia] <= b[ib] && a[ia] <= c[ic]){
                ia++;
            }else if(b[ib] <= a[ia] && b[ib] <= c[ic]){
                ib++;
            }else {
                ic++;
            }
        }
        return min;
    }
}
