/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   AllFactorsForGivenInt.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Print all factors of a given int
 *                    
 * All rights reserved.
 ******************************************************************************/
package number;

import java.util.ArrayList;
import java.util.List;

public class AllFactorsForGivenInt {
    public List<Integer> allFactor(int N) {
        List<Integer> res = new ArrayList<Integer>();
        int curUpper = N;
        res.add(1);
        if (N == 1) {
            return res;
        }
        for (int i = 2; i < curUpper; i++) {
            if (N % i == 0) {
                res.add(i);
                curUpper = N / i;
                if (curUpper != i) {
                    res.add(curUpper);
                }
            }
        }
        return res;
    }
}
