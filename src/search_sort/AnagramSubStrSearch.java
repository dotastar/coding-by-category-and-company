/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   AnagramSubStrSearch.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a text txt[0..n-1] and a pattern pat[0..m-1], 
 *                    write a function search(char pat[], char txt[]) that prints all occurrences of
 *                    pat[] and its permutations (or anagrams) in txt[].
 *                    Time Complexity is O(n)
 * All rights reserved.
 ******************************************************************************/
package search_sort;

import java.util.ArrayList;
import java.util.HashMap;

public class AnagramSubStrSearch {
    public ArrayList<Integer> search(char[] txt, char[] pat) {
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();
        HashMap<Character, Integer> has = new HashMap<Character, Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < pat.length; i++) {
            need.put(pat[i], need.containsValue(pat[i]) ? need.get(pat[i]) + 1 : 1);
        }
        int count = 0;
        for (int start = 0, end = start; end < txt.length; end++) {
            if (need.containsKey(txt[end])) {
                has.put(txt[end], has.containsKey(txt[end]) ? has.get(txt[end]) + 1 : 1);
                count++;
                while (has.get(txt[end]) > need.get(txt[end])) {
                    has.put(txt[start], has.get(txt[start]) - 1);
                    start++;
                    count--;
                }
                if (count == pat.length) {
                    ans.add(start);
                }
            } else {
                has.clear();
                start = end + 1;
                count = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AnagramSubStrSearch test = new AnagramSubStrSearch();
        System.out.println(test.search("BACDGABCDA".toCharArray(), "ABCD".toCharArray()));
    }
}
