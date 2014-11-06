/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   GroupSumMultipleOf3.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given an unsorted integer (positive values only) array of size 'n', 
 *                    we can form a group of two or three, the group should be such that the sum of all elements in that group is a multiple of 3.
 *                    Count all possible number of groups that can be generated in this way.
 *                    Refer: http://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/
 * All rights reserved.
 ******************************************************************************/
package number;

public class GroupSumMultipleOf3 {
    public int findGroups(int[] array){
        int[] remainder = new int[3];
        int res = 0;
        for(int i = 0; i < array.length; i++){
            remainder[array[i] % 3] ++;
        }
        res += (remainder[0] * (remainder[0] - 1)) / 2;
        res += remainder[1] * remainder[2];
        res += remainder[0] * (remainder[0] - 1) * (remainder[0] - 2) / 6;
        res += remainder[1] * (remainder[1] - 1) * (remainder[1] - 2) / 6;
        res += remainder[2] * (remainder[2] - 1) * (remainder[2] - 2) / 6;
        res += remainder[0] * remainder[1] * remainder[2];
        return res;
    }
}
