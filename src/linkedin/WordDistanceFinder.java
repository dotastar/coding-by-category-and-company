/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   WordDistanceFinder.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32763769.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordDistanceFinder {
    ArrayList<String> internal;

    public WordDistanceFinder(List<String> input) {
        internal = new ArrayList<String>(input);
    }

    public int distance(String a, String b) {
        int aIdx = -1, bIdx = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < internal.size(); i++) {
            if (internal.get(i).equals(a)) {
                aIdx = i;
            }
            if (internal.get(i).equals(b)) {
                bIdx = i;
            }
            if (aIdx != -1 && bIdx != -1) {
                min = Math.min(min, Math.abs(bIdx - aIdx));
            }
        }
        return min;
    }
    
    public static void main(String[] args) {
        WordDistanceFinder test = new WordDistanceFinder(Arrays.asList("the",
                "quick", "brown", "fox", "quick"));
        System.out.println(test.distance("fox", "the"));
        System.out.println(test.distance("quick", "fox"));
    }
}
