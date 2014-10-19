/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   TwoPartition.java
 *         Created:   Oct 18, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   1. the pack must be filled up! (BoundedWorkable.java, OR, init state must be Integer.Min_Value)
 *                    2. the pack don't need to be filled up and need be filled with as many as items.!(set the value to 1 for each items, and convert to normal Pack problems)
 *                    3. the pack volume need to be as closed as possible!(this problem) 
 *                    TwoPartition Problem:
 *                    Given a set of positive integers S = { a1,a2,a3,...,an} find two subsets s1 and s2 of A.
 *                    such that S2 = S - S1 and difference of | sum(S1) - sum(S2) | is minimum.
 *                    Modified ZeroOnePack problem                    
 * All rights reserved.
 ******************************************************************************/
package dp;

public class TwoPartition {
    public int partition(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i <= data.length; i++) {
            for (int j = sum / 2; j >= data[i - 1]; j--) {
                dp[j] = dp[j - data[i - 1]] || dp[j];
            }
        }
        int i = 0;
        for (; i <= sum / 2; i++) {//NOTE
            if (dp[sum / 2 - i]) {
                break;
            }
        }
        return sum / 2 - i;
    }

    public static void main(String[] args) {
        int[] data = new int[] { 3 };
        TwoPartition test = new TwoPartition();
        System.out.println(test.partition(data));
    }
}
