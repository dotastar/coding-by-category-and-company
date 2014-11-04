/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LuckyNumber.java
 *         Created:   Nov 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,...
 *                    First, delete every second number, we get following reduced set.
 *                    1,3,5,7,9,11,13,15,17,19,...
 *                    Now, delete every third number, we get 1, 3, 7, 9, 13, 15, 19,...
 *                    Continue this process indefinitely...
 *                    Any number that does NOT get deleted due to above process is called "lucky".
 *                    Therefore, set of lucky numbers is 1, 3, 7, 13,..
 *                    Refer: http://www.geeksforgeeks.org/lucky-numbers/
 * All rights reserved.
 ******************************************************************************/
package number;

public class LuckyNumber {
    //NOTE Integer Set is [1, Integer.MAX_VALUE], target >= 1, delCounter starts from 2
    public boolean isLucky(int target, int delCounter) {
        if (delCounter > target) {
            return true;
        }
        if (target % delCounter == 0) {
            return false;
        }
        target = target - target / delCounter;
        return isLucky(target, delCounter + 1);
    }
    
    public static void main(String[] args) {
        LuckyNumber test = new LuckyNumber();
        System.out.println(test.isLucky(19, 2));
    }
}
