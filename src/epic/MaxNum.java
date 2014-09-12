/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   GenerateWellOrderString.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find maximum number M less than N in which some specific digit is not allowed to exist
 *                    N: 83262; digit:2; M: 83199.
 * All rights reserved.
 ******************************************************************************/
package epic;

public class MaxNum {
    public int getMaxNum(int intput, int k) {
        String str = String.valueOf(intput);
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit == k) {
                ans = ans * 10 + mod(--digit);//NOTE
                for (int j = i + 1; j < str.length(); j++) {
                    ans = ans * 10 + set(str.charAt(i) - '0');
                }
                break;
            } else {
                ans = ans * 10 + digit;
            }
        }
        return ans;
    }

    private int set(int digit) {
        int i = 9;
        for (; i > 0; i--) {
            if (i != digit) {
                break;
            }
        }
        return i;
    }

    private int mod(int digit) {
        int res = digit % 10;
        return res < 10 ? res + 10 : res;
    }

    public static void main(String[] args) {
        MaxNum test = new MaxNum();
        System.out.println(test.getMaxNum(83262, 2));
        System.out.println(-11 % 10);
        System.out.println(test.getMaxNum(10100, 0));
    }
}
