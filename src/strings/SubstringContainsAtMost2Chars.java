/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SubstringContainsAtMost2Chars.java
 *         Created:   Nov 13, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given a string ,return the longest substring that contains at most two characters.
 *                    
 * All rights reserved.
 ******************************************************************************/
package strings;

import java.util.HashMap;

public class SubstringContainsAtMost2Chars {
    public String longestSubString(String str) {
        int start = 0, max = Integer.MIN_VALUE, maxIdx = -1;
        HashMap<Character, Integer> set = new HashMap<Character, Integer>();
        for (int end = start; end < str.length(); end++) {
            set.put(str.charAt(end), set.containsKey(str.charAt(end)) ? set.get(str.charAt(end)) + 1 : 1);
            while (set.size() > 2) {
                if(set.get(str.charAt(start))  > 1){
                    set.put(str.charAt(start), set.get(str.charAt(start)) - 1);
                }else{
                    set.remove(str.charAt(start));
                }
                start++;
            }
            if(max < end - start + 1){
                max = end - start + 1;
                maxIdx = start;
            }
        }
        return str.substring(maxIdx, maxIdx + max);
    }
    
    public static void main(String[] args) {
        SubstringContainsAtMost2Chars test = new SubstringContainsAtMost2Chars();
        System.out.println(test.longestSubString("abdedeftftfedddddddd"));
    }
}
