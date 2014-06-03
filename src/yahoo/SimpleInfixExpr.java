/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   SimpleInfixExpr.java
 *         Version:   1.0
 *         Created:   5/29 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   compute infix expression: 4 + 4 * 4 / 2 (No parenthesis)
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class SimpleInfixExpr {
    /**
     * my programming idea
     */
    public double computeInfixExpr(String input) {
        String[] expr = input.split(" ");
        int i = 0;
        double operLeft = Integer.valueOf(expr[i++]);
        while (i < expr.length) {
            String operator = expr[i++];
            double operRight = Double.valueOf(expr[i++]);
            switch (operator) {
                case "*":
                    operLeft = operLeft * operRight;
                    break;
                case "/":
                    operLeft = operLeft / operRight;
                    break;
                case "+":
                case "-":
                    while (i < expr.length) {
                        String termOperator = expr[i++];
                        if (termOperator.equals("+") || termOperator.equals("-")) {
                            i--;
                            break;
                        }
                        if (termOperator.equals("*")) {
                            operRight = operRight * Double.valueOf(expr[i++]);
                        } else {
                            operRight = operRight / Double.valueOf(expr[i++]);
                        }
                    }
                    if (operator.equals("+")) {
                        operLeft = operLeft + operRight;
                    } else {
                        operLeft = operLeft - operRight;
                    }
                    break;
            }
        }
        return operLeft;
    }

    /**
     * CJ's programming idea
     */
    public double computeInfixExpr2(String input) {
        String[] expr = input.split(" ");
        int i = 0;
        double operLeft = 0, operRight = Double.valueOf(expr[i++]);
        String lastOptor = "+";
        while(i < expr.length){
            String curOptor = expr[i++]; 
            switch(curOptor){
                case "*":
                    operRight = operRight * Double.valueOf(expr[i++]);
                    break;
                case "/":
                    operRight = operRight / Double.valueOf(expr[i++]);
                    break;
                case "+":
                case "-":
                    operLeft = computeTerm(operLeft, lastOptor, operRight);
                    operRight = Double.valueOf(expr[i++]);
                    lastOptor = curOptor;
                    break;
            }
        }
        operLeft = computeTerm(operLeft, lastOptor, operRight);
        return operLeft;
    }
    
    public double computeTerm(double operLeft, String operator, double operRight){
        switch(operator){
            case "+":
                return operLeft + operRight;
            case "-":
                return operLeft - operRight;
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) {
        SimpleInfixExpr test = new SimpleInfixExpr();
        System.out.println(test.computeInfixExpr2("4 * 3 / 2 + 3 - 4 * 2 + 2 * 3"));
    }
}
