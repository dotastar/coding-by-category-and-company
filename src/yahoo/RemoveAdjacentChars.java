/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RemoveAdjacentChars.java
 *         Created:   Oct 3, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a string, complete the given function to recursively remove the adjacent duplicate characters and return the resultant string.
 *                    If there are no characters left in the resultant string, return "-1" (without quotes). 
 *                    Sample Input: ABCCBCBA Output: ACBA  
 *                    
 * All rights reserved.
 ******************************************************************************/
package yahoo;

public class RemoveAdjacentChars {
    public static String remove(char[] data, int oldLen) {
        if(oldLen == 0){
            return null;
        }
        int newLen = 0, s = 0, e = 0;
        for (; e < oldLen; e++) {
            if (data[e] != data[s]) {
                if (e - s == 1) {
                    data[newLen++] = data[s];
                }
                s = e;
            }
        }
        if(e - s == 1){
            data[newLen++] = data[s];
        }
        return newLen == oldLen ? new String(data, 0, oldLen) : remove(data, newLen);
    }

    public static void main(String[] args) {
        char[] data = { 'A','B','C','C','B','C','B','A'  };
        System.out.println(remove(data, 8));
    }
}
