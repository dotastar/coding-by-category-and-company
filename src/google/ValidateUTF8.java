/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ValidateUTF8.java
 *         Created:   Nov 10, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Refer: http://codereview.stackexchange.com/questions/59428/validating-utf-8-byte-array
 *                    Refer: http://www.ruanyifeng.com/blog/2007/10/ascii_unicode_and_utf-8.html
 *                    
 * All rights reserved.
 ******************************************************************************/
package google;

public class ValidateUTF8 {
    public boolean validate(byte[] bytes) {
        int expectedLen = 0;
        if (bytes.length == 0) {
            return false;
        } else if ((bytes[0] & 0b10000000) == 0b00000000) {
            expectedLen = 1;
        } else if ((bytes[0] & 0b11100000) == 0b11000000) {
            expectedLen = 2;
        } else if ((bytes[0] & 0b11110000) == 0b11100000) {
            expectedLen = 3;
        } else if ((bytes[0] & 0b11111000) == 0b11110000) {
            expectedLen = 4;
        } else if ((bytes[0] & 0b11111100) == 0b11111000) {
            expectedLen = 5;
        } else if ((bytes[0] & 0b11111110) == 0b11111100) {
            expectedLen = 6;
        } else {
            return false;
        }
        if (expectedLen != bytes.length) {
            return false;
        }
        for (int i = 1; i < bytes.length; i++) {
            if ((bytes[i] & 0b11000000) != 0b10000000) {
                return false;
            }
        }
        return true;
    }
}
