/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SuffixArray.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   LCP(i, j) = lcp(suffix(SA[i]), suffix(SA[j])), i, j belongs to (0, N-1)
 *                    theorem 1: LCP(i, j) = min{Height[k], i+1<=k<=j}, think why?
 *                    theorem 2: if Rank(i) > 0, Height[Rank[i]] >= Height[Rank[i - 1]] - 1, so compute Height only need O(n)
 *                    Proof: assume suffix(k) ranks in front suffix(i-1), so lcp for i-1 is LCP[Rank[i-1]] (assume LCP[Rank[i-1]] > 0)
 *                           so suffix(k+1) must rank ahead of suffix(i), so lcp of (k+1, i) is LCP[Rank[i-1]] - 1
 *                           so LCP[Rank[i]-1, Rank[i]] must at least be LCP[Rank[i-1]] - 1
 *                    Refer: http://dongxicheng.org/structure/suffix-array/
 * All rights reserved.
 ******************************************************************************/
package suffixarray;

import java.util.ArrayList;
import java.util.Collections;

public class SuffixArray {

    private int[] SA;//SA[i] means start_idx of suffix which ranks at i
    private int[] Rank;//Rank[i] means rank value of suffix which start_idx is i
    private int[] Height;//Height[i] means the longest common prefix between suffix(SA[i-1]) and suffix(SA[i])
    private String data;

    public SuffixArray(String data) {
        SA = new int[data.length()];
        Rank = new int[data.length()];
        Height = new int[data.length()];
        this.data = data;
    }

    //this is naive way, suffix_array can be built in O(nlogn)
    public void buildSuffixArray() {
        ArrayList<String> suffix = new ArrayList<String>();
        for (int i = 0; i < data.length(); i++) {
            suffix.add(data.substring(i));
        }
        Collections.sort(suffix);
        for (int i = 0; i < data.length(); i++) {
            SA[i] = data.length() - suffix.get(i).length();
            Rank[data.length() - suffix.get(i).length()] = i;
        }
        int k = 0;
        for (int i = 0; i < data.length(); i++) {
            if (k > 0) {//NOTE theorem 2
                k--;
            }
            if (Rank[i] == 0) {
                Height[0] = 0;//NOTE
            } else {
                int j = SA[Rank[i] - 1];
                while (i + k < data.length() && j + k < data.length() && data.charAt(i + k) == data.charAt(j + k)) {
                    k++;
                }
                Height[Rank[i]] = k;//NOTE
            }
        }
    }

    //use binary search to search suffix array
    public int searchPattern(String pat) {
        int l = 0, r = SA.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (compare(data.substring(SA[mid]), pat) == 0) {
                return SA[mid];
            } else if (compare(data.substring(SA[mid]), pat) < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int compare(String txt, String pat) {
        int i = 0, j = 0;
        while (i < txt.length() && j < pat.length()) {
            if (txt.charAt(i) < pat.charAt(j)) {
                return 1;
            } else if (txt.charAt(i) > pat.charAt(j)) {
                return -1;
            }
            i++;
            j++;
        }
        return j == pat.length() ? 0 : 1;
    }

    public static void main(String[] args) {
        SuffixArray test = new SuffixArray("banana");
        test.buildSuffixArray();
        System.out.println(test.searchPattern("nan"));
    }
}
