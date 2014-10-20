/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckOneEdit.java
 *         Created:   Oct 19, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   check if one string can be converted from another by exact one edit
 *                    
 * All rights reserved.
 ******************************************************************************/
package facebook;

public class CheckOneEdit {
    public boolean check(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) {
            return false;
        }
        if (a.length() > b.length()) {
            return check(b, a);
        }
        boolean oneEdit = false;
        for (int i = 0, j = 0; i < a.length() && j < b.length(); i++, j++) {
            if (a.charAt(i) != b.charAt(j)) {
                if (oneEdit) {
                    return false;
                } else {
                    if (a.length() != b.length()) {
                        i--;
                    }
                    oneEdit = true;
                }
            }
        }
        return oneEdit == true ? true : false;//NOTE
    }
}
