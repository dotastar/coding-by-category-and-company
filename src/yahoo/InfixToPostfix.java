/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   InfixToPostfix.java
 *         Version:   1.0
 *         Created:   6/2 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Infix to Postfix Conversion, the intuition please see my gist
 *            
 * All rights reserved.
 ******************************************************************************/
package yahoo;

import java.util.Stack;

public class InfixToPostfix {
    public String convert(String input) {
        String[] data = input.split(" ");
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case "+":
                case "-":
                    sb.append(popUtil(data[i], stack));
                    stack.push(data[i]);
                    break;
                case "*":
                case "/":
                    sb.append(popUtil(data[i], stack));
                    stack.push(data[i]);
                    break;
                case "(":  
                    stack.push(data[i]);  
                    break;  
                case ")":
                    sb.append(popUtil(data[i], stack));
                    break;
                default:
                    sb.append(" " + data[i]);
            }
        }
        while (!stack.empty()) {
            sb.append(" " + stack.pop());
        }
        return sb.toString();
    }

    public String popUtil(String cur, Stack<String> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            if (getPriority(stack.peek()) >= getPriority(cur)) {
                sb.append(" " + stack.pop());
            } else {
                if (cur.equals(")")) {
                    stack.pop();//pop out "("
                }
                break;
            }
        }
        return sb.toString();
    }

    public int getPriority(String target) {
        switch (target) {
            case "(":
                return 0;
            case ")":
                return 1;
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            default:
                return -1;
        }
    }
    
    public static void main(String[] args) {
        InfixToPostfix test = new InfixToPostfix();
        System.out.println(test.convert("( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )"));
    }
}
