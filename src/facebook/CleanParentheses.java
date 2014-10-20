/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CleanParentheses.java
 *         Created:   Oct 18, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a parentheses string, how many parenthese chars will be removed at least to convert it to a valid string 
 *                    eg ((()) -> (())
 *                    and print the valid string after cleaning
 * All rights reserved.
 ******************************************************************************/
package facebook;

import java.util.Stack;

public class CleanParentheses {
    public int compute(String s) {
        int[] maxValid = new int[s.length()], dp = new int[s.length() + 1];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                maxValid[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            } else {
                stack.push(i);
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = maxValid[i - 1] == 0 ? dp[i - 1] + 1 : dp[i - maxValid[i - 1]];
        }
        /*print the valid parenthese after cleaning O(n)*/
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            if(maxValid[i] != 0){
                sb.insert(0, s.substring(i - maxValid[i] + 1, i + 1));
                i = i - maxValid[i];
            }else{
                i--;
            }
        }
        System.out.println(sb.toString());
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
        CleanParentheses test = new CleanParentheses();
        System.out.println(test.compute("((())))((())("));
        System.out.println(test.compute("(((("));
        System.out.println(test.compute(")))((("));
    }
}
