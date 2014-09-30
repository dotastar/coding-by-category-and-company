/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TwoSmallest.java
 *         Created:   Sep 25, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to find two smallest number index of an array in place, this solution need 1 + 2 * (n - 2) operations in worst case
 *                    
 * All rights reserved.
 ******************************************************************************/
package bloomberg;

public class TwoSmallest {
    public void findTwoSmallest(int[] data) {
        int min1 = data[0], min2 = data[1];
        if (min2 < min1) {
            min1 = data[1];
            min2 = data[0];
        }
        for (int i = 2; i < data.length; i++) {
            if (data[i] < min1) {
                min2 = min1;
                min1 = data[i];
            } else if (data[i] < min2) {
                min2 = data[i];
            }
        }
        System.out.println(min1 + " " + min2);
    }
}
