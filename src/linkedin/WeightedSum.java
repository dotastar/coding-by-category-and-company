/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   WeightedSum.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32734797.html
 *            
 * All rights reserved.
 ******************************************************************************/

package linkedin;

import java.util.ArrayList;

public class WeightedSum {
    public int getSum(Object ob, int depth) {
        if (ob == null) {
            return 0;
        }
        int sum = 0;
        if (ob instanceof ArrayList) {
            for (Object iter : (ArrayList<Object>) ob) {
                if (ob instanceof ArrayList) {
                    sum += getSum(iter, depth + 1);
                } else {
                    sum += getSum(iter, depth);
                }
            }
        } else {
            sum += (Integer) ob * depth;
        }
        return sum;
    }
}
