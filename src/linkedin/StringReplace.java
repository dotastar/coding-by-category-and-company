/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   StringReplace.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32692253_0_1.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

import java.util.ArrayList;

public class StringReplace {
    public ArrayList<Integer> search(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (p.length() == 0) {
            return ans;
        }
        int sSize = s.length(), pSize = p.length();
        int[] failure = new int[p.length()];
        computeFailure(failure, p);
        int sIdx = 0, pIdx = 0;
        while (sIdx < sSize) {
            if (pIdx == p.length()) {
                ans.add(sIdx - pSize);//NOTE
                pIdx = 0;
            } else {
                if (s.charAt(sIdx) == p.charAt(pIdx)) {
                    sIdx++;
                    pIdx++;
                } else if (pIdx > 0) {
                    pIdx = failure[pIdx - 1] + 1;
                } else {
                    sIdx++;
                }
            }
        }
        if(pIdx == p.length()){//NOTE
            ans.add(sIdx - pSize);
        }
        return ans;
    }

    private void computeFailure(int[] failure, String p) {
        failure[0] = -1;
        for (int i = 1; i < failure.length; i++) {
            int j = failure[i - 1];
            while (j >= 0 && p.charAt(j + 1) == p.charAt(i)) {
                j = failure[j];
            }
            if (p.charAt(j + 1) == p.charAt(i)) {
                failure[i] = j + 1;
            } else {
                failure[i] = -1;
            }
        }
    }

    public static void main(String[] args) {
        StringReplace test = new StringReplace();
        ArrayList<Integer> res = test.search("abcdenzabcdenzabcdenz", "nz");
        for(Integer iter : res) {
            System.out.println(iter);
        }
    }
}
