/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RabinKarpForBinaryCodeSearch.java
 *         Created:   Nov 15, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   given byte[] data, length of data (in bit), byte[] pattern, length of pattern (in bit)
 *                    find all positions in which pattern matches data
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.ArrayList;

public class RabinKarpForBinaryCodeSearch {
    
    public int getPosInBinaryCode(byte[] bytes, int idx) {
        int full = idx / 8, offset = idx % 8;
        byte cur = bytes[full];
        return ((cur & 0xff) & (1 << (7 - offset))) == 0 ? 0 : 1;// NOTE byte sign extension
    }

    private long preHash(byte[] bytes, long R, int size) {
        long h = 0;
        for (int  i= 0; i < size; i++)
            h = (R * h + getPosInBinaryCode(bytes, i));
        return h;
    }
    
    private boolean check(byte[] txt, int i, byte[] pat, int pSize) {
        for (int j = 0; j < pSize; j++) {
            if (getPosInBinaryCode(pat, j) != getPosInBinaryCode(txt, i + j)) {
                return false;
            }
        }
        return true;
    }
    
    public ArrayList<Integer> search(byte[] txt, int tSize, byte[] pat, int pSize) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        long R = 31;//R: radix
        long RM = 1;//R^(M-1) for use in removing leading digit
        for (int i = 1; i <= pSize - 1; i++) {
            RM = (R * RM);
        }
        long patHash = preHash(pat, R, pSize);
        long txtHash = preHash(txt, R, pSize);
        if ((patHash == txtHash) && check(txt, 0, pat, pSize)) {
            ans.add(0);
        }
        for (int i = pSize; i < tSize; i++) {
            txtHash = (txtHash - RM * getPosInBinaryCode(txt, i - pSize));
            txtHash = (txtHash * R +getPosInBinaryCode(txt, i));
            if ((patHash == txtHash) && check(txt, i - pSize+ 1, pat, pSize)) {
                ans.add(i - pSize + 1);
            }
        }
        return ans;
    }
}
