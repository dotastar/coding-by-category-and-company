/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FairCoinFromBiasedCoin.java
 *         Created:   Nov 4, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   You are given a function foo() that represents a biased coin. 
 *                    When foo() is called, it returns 0 with 60% probability, and 1 with 40% probability.
 *                    Write a new function that returns 0 and 1 with 50% probability each.    
 *                    (0, 1): The probability to get 0 followed by 1 from two calls of foo() = 0.6 * 0.4 = 0.24
 *                    (1, 0): The probability to get 1 followed by 0 from two calls of foo() = 0.4 * 0.6 = 0.24
 * All rights reserved.
 ******************************************************************************/
package number;

public class FairCoinFromBiasedCoin {
    public int foo() {
        return 0; //given method that returns 0 with 60% probability and 1 with 40%
    }

    // returns both 0 and 1 with 50% probability
    public int genFairCoin() {
        int val1 = foo(), val2 = foo();
        if (val1 == 0 && val2 == 1) {// Will reach here with 0.24 probability
            return 0;
        }
        if (val1 == 1 && val2 == 0) {// Will reach here with 0.24 probability
            return 1;
        }
        return genFairCoin();//else we will re-invoke this function
    }
}
