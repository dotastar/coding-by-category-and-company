/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   InfixExprNoParenthesis.java
 *         Created:   5/29 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   compute infix expression: 4 + 4 * 4 / 2 (No parenthesis)
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class InfixExprNoParenthesis {

    public double computeInfixExpr2(String input) {
        String[] expr = input.split(" ");
        if(expr.length == 0){
            return Double.valueOf(expr[0]);
        }
        int i = 0;
        double left = Double.valueOf(expr[i++]);
        String lastOpter = expr[i++];
        double right = Double.valueOf(expr[i++]);
        while(i < expr.length){
            String curOpter = expr[i++]; 
            switch(curOpter){
                case "*":
                    right = right * Double.valueOf(expr[i++]);
                    break;
                case "/":
                    right = right / Double.valueOf(expr[i++]);
                    break;
                case "+":
                case "-":
                    left = computeLeft(left, lastOpter, right);
                    right = Double.valueOf(expr[i++]);
                    lastOpter = curOpter;
                    break;
            }
        }
        left = computeLeft(left, lastOpter, right);
        return left;
    }
    
    public double computeLeft(double left, String operater, double right){
        switch(operater){
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) {
        InfixExprNoParenthesis test = new InfixExprNoParenthesis();
        System.out.println(test.computeInfixExpr2("4 * 3 / 2 + 3 - 4 * 2 + 2 * 3"));
    }
}
