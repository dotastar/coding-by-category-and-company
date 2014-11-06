/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LexicographicRankOfAString.java
 *         Created:   Nov 4, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:    
 *                    
 * All rights reserved.
 ******************************************************************************/
package number;

public class LexicographicRankOfAString {
    int fact(int n) {
        return n <= 1 ? 1 : n * fact(n - 1);
    }

    public int findSmallerInRight(String str, int start) {
        int countRight = 0;
        for (int i = start + 1; i < str.length(); i++) {
            if (str.charAt(i) < str.charAt(start)) {
                countRight++;
            }
        }
        return countRight;
    }

    public int findRank(String str) {
        int len = str.length(), mul = fact(str.length()), rank = 0, countRight = 0;
        for (int i = 0; i < len; i++) {
            mul /= len - i;
            countRight = findSmallerInRight(str, i);
            rank = countRight * mul;
        }
        return rank;
    }
}
