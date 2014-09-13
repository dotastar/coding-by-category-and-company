/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   LookAndSay.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   LookAndSay
 * All rights reserved.
 ******************************************************************************/
package epic;

public class LookAndSay {
    public String countAndSay(String start, int n) {
        String ans = start;
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1, j = 1;
            for (; j < ans.length(); j++) {
                if (ans.charAt(j) != ans.charAt(j - 1)) {
                    sb.append(count).append(ans.charAt(j - 1));
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count).append(ans.charAt(j - 1));
            ans = sb.toString();
        }
        return ans;
    }
}
