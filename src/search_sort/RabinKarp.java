/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RabinKarp.java
 *         Created:   Oct 22, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Implementation of Rabin-Karp algorithm, best time O(n + m), worst time O(n*m) 
 *                    
 * All rights reserved.
 ******************************************************************************/
package search_sort;

public class RabinKarp {

    private long preHash(String key, long R, int M) {// Compute hash for key[0..M-1].
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j));
        return h;
    }

    private boolean check(String txt, int i, String pat) {
        for (int j = 0; j < pat.length(); j++) {
            if (pat.charAt(j) != txt.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    public int search(String txt, String pat) {
        long R = 101;//R: radix
        long RM = 1;//R^(M-1) for use in removing leading digit
        for (int i = 1; i <= pat.length() - 1; i++) {
            RM = (R * RM);
        }
        long patHash = preHash(pat, R, pat.length());
        long txtHash = preHash(txt, R, pat.length());
        if ((patHash == txtHash) && check(txt, 0, pat)) {
            return 0;
        }
        for (int i = pat.length(); i < txt.length(); i++) {
            txtHash = (txtHash - RM * txt.charAt(i - pat.length()));
            txtHash = (txtHash * R + txt.charAt(i));
            if ((patHash == txtHash) && check(txt, i - pat.length() + 1, pat)) {
                return i - pat.length() + 1;
            }
        }
        return -1;
    }
}
