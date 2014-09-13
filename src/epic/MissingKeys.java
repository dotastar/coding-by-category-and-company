/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MissingKeys.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   1-9 keypad one key is not working. If some one enters a password then not working key will not be entered. 
 *                    You have given expected password and entered password. Check that entered password is valid or not 
 *                    actual: 164
 *                    expected: 1864 -->right; 18684-->right; 18684888-->right; 186847--->wrong;
 * All rights reserved.
 ******************************************************************************/
package epic;

import java.util.HashSet;

public class MissingKeys {
    public boolean checkValid(String actual, String expected) {
        char faultKey = '\0';
        int i = 0, j = 0;
        HashSet<Character> matched = new HashSet<Character>();//matched set
        while (i < actual.length() && j < expected.length()) {
            char cur = actual.charAt(i);
            matched.add(cur);
            if (cur != expected.charAt(j)) {
                if (faultKey == '\0') {
                    faultKey = expected.charAt(j);
                }
                if (faultKey != expected.charAt(j) || matched.contains(faultKey)) {//NOTE
                    return false;
                }
            } else {
                if (cur == faultKey) {//NOTE
                    return false;
                }
                i++;
            }
            j++;
        }
        while (j < expected.length()) {
            char iter = expected.charAt(j);
            if (iter != faultKey || matched.contains(iter)) {
                break;
            }
            j++;
        }
        return i == actual.length() && j == expected.length();
    }
}
