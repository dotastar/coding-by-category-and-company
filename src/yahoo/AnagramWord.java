/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   AnagramWord.java
 *         Created:   Oct 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given two words, determine if the first word, or any anagram of it, appears in consecutive characters of the second word. 
 *                    
 * All rights reserved.
 ******************************************************************************/
package yahoo;

import java.util.HashMap;

public class AnagramWord {
    public static String search(String str, String p) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        HashMap<Character, Integer> has = new HashMap<Character, Integer>();
        for (int i = 0; i < p.length(); i++) {
            freq.put(p.charAt(i), freq.get(p.charAt(i)) == null ? 1 : freq.get(p.charAt(i)) + 1);
        }
        int s = 0, e = 0;
        for (; e < str.length(); e++) {
            if (e - s == p.length()) {
                break;
            }
            if (freq.containsKey(str.charAt(e))) {
                has.put(str.charAt(e), has.get(str.charAt(e)) == null ? 1 : has.get(str.charAt(e)) + 1);
                while (has.get(str.charAt(e)) > freq.get(str.charAt(e))) {
                    has.put(str.charAt(s), has.get(str.charAt(s)) == 1 ? null : has.get(str.charAt(s)) - 1);
                    s++;
                }
            } else {
                has.clear();
                s = e + 1;
            }
        }
        return e - s < p.length() ? null : str.substring(s, e);
    }

    public static void main(String[] args) {
        System.out.println(search("slattea", "eat"));
        System.out.println(search("slate", "let"));
    }
}
