/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SuffixArray.java
 *         Created:   Oct 26, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   LCP(i, j) = lcp(suffix(SA[i]), suffix(SA[j])), i, j belongs to (0, N-1)
 *                    theorem 1: LCP(i, j) = min{Height[k], i+1<=k<=j}, think why?
 *                    theorem 2: if Rank(i) > 0, Height[Rank[i]] >= Height[Rank[i - 1]] - 1, so computing Height array only needs O(n)
 *                    Proof: assume LCP[Rank[i-1]] = LCP(suffix(k), suffix(i-1)) 
 *                           so suffix(k+1) must rank ahead of suffix(i), so LCP(suffix(k+1), suffix(i)) is LCP[Rank[i-1]] - 1
 *                           soLCP[Rank[i]] must at least be LCP[Rank[i-1]] - 1.
 *                    Refer: http://dongxicheng.org/structure/suffix-array/
 *                           http://yzmduncan.iteye.com/blog/979771
 *                           http://www.cnblogs.com/looker_acm/archive/2010/07/18/1780191.html
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

    //this is naive way, suffix_array can be built in O(nlogn) using other ways
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
        int k = 0;//NOTE Height[] array is built by O(n)
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

    //NOTE find longest repeating substring which can be overlapped! O(n)
    public String longestRepeatingSubStrI() {
        int maxPrefix = Integer.MIN_VALUE, idx = 0;
        for (int i = 0; i < Height.length; i++) {
            if (Height[i] > maxPrefix) {
                maxPrefix = Height[i];
                idx = i;
            }
        }
        String suffix = data.substring(SA[idx]);
        return suffix.substring(0, maxPrefix);
    }

    //NOTE find longest repeating substring which can not be overlapped! O(nlogn)
    public String longestRepeatingSubStrII() {
        int l = 0, r = data.length() / 2, longest = 0, maxIdx = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int tmpIdx = check(mid);
            if (tmpIdx != -1) {
                maxIdx = tmpIdx;
                longest = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        String suffix = data.substring(maxIdx);
        return suffix.substring(0, longest);
    }

    public int check(int k) {
        int min = SA[0], max = SA[0];
        for (int i = 1; i < SA.length; i++) {
            if (Height[i] >= k) {
                min = Math.min(min, SA[i]);
                max = Math.max(max, SA[i]);
                if (max - min >= k) {
                    return max;
                }
            } else {
                max = min = SA[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SuffixArray test1 = new SuffixArray("banana");
        test1.buildSuffixArray();
        System.out.println(test1.searchPattern("nan"));
        System.out.println(test1.longestRepeatingSubStrI());
        SuffixArray test2 = new SuffixArray("acaca");
        test2.buildSuffixArray();
        System.out.println(test2.longestRepeatingSubStrI());
        System.out.println(test2.longestRepeatingSubStrII());
        SuffixArray test3 = new SuffixArray("acacacac");
        test3.buildSuffixArray();
        System.out.println(test3.longestRepeatingSubStrI());
        System.out.println(test3.longestRepeatingSubStrII());
        SuffixArray test4 = new SuffixArray("acabegacab");
        test4.buildSuffixArray();
        System.out.println(test4.longestRepeatingSubStrII());
    }
}
