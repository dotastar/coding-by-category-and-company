/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   GenerateWellOrderString.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Generate all strings with specific length in which the letters must occur in alphabet
 *            
 * All rights reserved.
 ******************************************************************************/
package epic;

import java.util.ArrayList;

public class GenerateWellOrderString {
    public ArrayList<String> generate(int len) {
        ArrayList<String> ans = new ArrayList<String>();
        search(ans, new char[len], 0, 'a', len);
        return ans;
    }

    private void search(ArrayList<String> ans, char[] cal, int idx, char start, int left) {
        if (left == 0) {
            ans.add(new String(cal));
            return;
        }
        for(char ch = start; ch <= 'e' - (left - 1); ch++) {
            cal[idx] = ch;
            search(ans, cal, idx + 1, (char)(ch + 1), left - 1);
        }
    }

    public static void main(String[] args) {
        GenerateWellOrderString test = new GenerateWellOrderString();
        System.out.println(test.generate(4));
    }
}
