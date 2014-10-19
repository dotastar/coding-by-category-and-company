/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Generate125.java
 *         Created:   Oct 17, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given Random5() -- > 1 ~ 5, generate 1-->125 with equal probability
 *                    generate 1-- >125 by decreasing 1, --> generate 0-->124
 *                    0-->124 by 5-scale is 000->444, so we could use Random5() to generate 5-scale 
 *                    
 * All rights reserved.
 ******************************************************************************/
package yahoo;

public class Generate125 {
    public int Random125() {
        int result = 0;
        result += 25 * (Random5() - 1);
        result += 5 * (Random5() - 1);
        result += (Random5() - 1);
        return result + 1;
    }

    public int Random5() {
        return 0;//this is interface given from outside
    }
}
