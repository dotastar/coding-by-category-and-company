/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   InfixExprParenthesis.java
 *         Created:   6/03 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   compute infix expression: 4 + 4 + (4 - 2) (Contain parenthesis)
 *                    each time when we encounter the "(", program go into next layer recursively.
 *                    each time when we encounter the ")", program return to last layer.
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class InfixExprParenthesis {
    private int idx = 0;
    
    public double computeInfixExpr(String input) {
        return compute(input.split(" "));
    }
    
    public double compute(String[] expr) {
        double left = 0, right = expr[idx++].equals("(") ? compute(expr) : Double.valueOf(expr[idx - 1]);
        String lastOptor = "+";
        while(idx < expr.length){
            String curOptor = expr[idx++]; 
            switch(curOptor){
                case "*":
                    right = right * (expr[idx++].equals("(") ? compute(expr) : Double.valueOf(expr[idx - 1]));
                    break;
                case "/":
                    right = right / (expr[idx++].equals("(") ? compute(expr) : Double.valueOf(expr[idx - 1]));
                    break;
                case "+":
                case "-":
                    left = computeLeft(left, lastOptor, right);
                    right = (expr[idx++].equals("(") ? compute(expr) : Double.valueOf(expr[idx - 1]));
                    lastOptor = curOptor;
                    break;
            }
            if(curOptor.equals(")")){
                break;
            }
        }
        left = computeLeft(left, lastOptor, right);
        return left;
    }
    
    public double computeLeft(double left, String operator, double right){
        switch(operator){
            case "+":
                return left + right;
            case "-":
                return left - right;
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) {
        InfixExprParenthesis test = new InfixExprParenthesis();
        System.out.println(test.computeInfixExpr("2 * ( 2 - 4 ) - ( ( 3 - 1 ) - ( 3 + 1 ) )"));
    }
}
