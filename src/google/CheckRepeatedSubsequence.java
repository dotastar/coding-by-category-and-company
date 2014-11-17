/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckRepeatedSubsequence.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a string, find if there is any sub-sequence that repeats itself. 
 *                    eg. acbdaghfb <-------- yes there is a followed by b at two places
 *                    abba <---- No, a and b follow different order 
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CheckRepeatedSubsequence {
    public boolean check(char[] str) {
        HashMap<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();
        for (int i = 0; i < str.length; i++) {
            if (!map.containsKey(str[i])) {
                map.put(str[i], new LinkedList<Integer>());
            }
            map.get(str[i]).add(i);
        }
        ArrayList<LinkedList<Integer>> idx = new ArrayList<LinkedList<Integer>>();
        for (Map.Entry<Character, LinkedList<Integer>> iter : map.entrySet()) {
            if (iter.getValue().size() > 1) {
                idx.add(iter.getValue());
            }
        }
        for (int i = 0; i < idx.size() - 1; i++) {
            for (int j = i + 1; j < idx.size(); j++) {
                StringBuilder txt = new StringBuilder(), pat = new StringBuilder(), patRev = new StringBuilder();
                pat.append(str[idx.get(i).get(0)]).append(str[idx.get(j).get(0)]).append(str[idx.get(i).get(0)])
                        .append(str[idx.get(j).get(0)]);//NOTE
                patRev.append(str[idx.get(j).get(0)]).append(str[idx.get(i).get(0)]).append(str[idx.get(j).get(0)])
                        .append(str[idx.get(i).get(0)]);//NOTE
                int l = 0, k = 0;
                while (l < idx.get(i).size() || k < idx.get(j).size()) {
                    int a = l < idx.get(i).size() ? idx.get(i).get(l) : Integer.MAX_VALUE;
                    int b = k < idx.get(j).size() ? idx.get(j).get(k) : Integer.MAX_VALUE;
                    if (a < b) {
                        txt.append(str[idx.get(i).get(l)]);
                        l++;
                    } else {
                        txt.append(str[idx.get(j).get(k)]);
                        k++;
                    }
                }
                if (txt.indexOf(pat.toString()) != -1 || txt.indexOf(patRev.toString()) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckRepeatedSubsequence test = new CheckRepeatedSubsequence();
        System.out.println(test.check("abcdedfsctopf".toCharArray()));
    }
}
