/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StringToLong.java
 *         Created:   Sep 24, 2014 
 *          Author:   Nan Zhang 
 *            Note:   Convert string to long. Limitation: this code doesn't report exception when string contains invalid chars
 *                    
 * All rights reserved.
 ******************************************************************************/
package zillow;

import java.util.Random;

import junit.framework.Assert;

public class StringToLong {

    public static long stringToLong(String input) {
        int idx = 0;
        long res = 0;
        while (idx < input.length() && Character.isWhitespace(input.charAt(idx))) {
            idx++;
        }
        if (idx == input.length()) {
            throw new IllegalArgumentException("Error: string is empty!");
        }
        boolean isNegative = false, isOverflow = false;
        if (input.charAt(idx) == '+' || input.charAt(idx) == '-') {
            isNegative = input.charAt(idx) == '+' ? false : true;
            idx++;
        }
        for (; idx < input.length() && input.charAt(idx) >= '0' && input.charAt(idx) <= '9'; idx++) {
            if (Long.MAX_VALUE / 10 < res) {//check overflow
                isOverflow = true;
                break;
            }
            res = res * 10;
            if (Long.MAX_VALUE - (input.charAt(idx) - '0') < res) {//check overflow
                isOverflow = true;
                break;
            }
            res += (input.charAt(idx) - '0');
        }
        if (isOverflow) {//the valid range for Long is [-2^63, 2^63 - 1]
            return isNegative ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return isNegative ? -1 * res : res;
    }

    public static void testGeneral() {
        int iterNum = 100;
        Random randomno = new Random();
        for (int i = 0; i < iterNum; i++) {
            long expected = randomno.nextLong();
            Assert.assertEquals(expected, stringToLong(String.valueOf(expected)));
        }
    }

    public static void testBoundary() {
        String longMax = "9223372036854775807"; // 2^63-1
        String longMin = "-9223372036854775808"; // -2^63
        Assert.assertEquals((long) (Math.pow(2, 63) - 1), stringToLong(longMax));
        Assert.assertEquals((long) (-1 * Math.pow(2, 63)), stringToLong(longMin));
    }

    public static void testInvalidString() {
        try {
            stringToLong("   ");
            Assert.fail("No error report!");
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }

    public static void main(String args[]) {
        testGeneral();
        testBoundary();
        testInvalidString();
        System.out.println("test complete!");
    }
}
