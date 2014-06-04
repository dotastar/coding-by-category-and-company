/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ComplexInfixExpr.java
 *         Version:   1.0
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

public class ComlexInfixExpr {
    private static int globIdx = 0;
    
    public double computeInfixExpr(String input) {
        return compute(input.split(" "));
    }
    
    public double compute(String[] expr) {
        double operLeft = 0, operRight = expr[globIdx++].equals("(") ? compute(expr) : Double.valueOf(expr[globIdx - 1]);
        String lastOptor = "+";
        while(globIdx < expr.length){
            String curOptor = expr[globIdx++]; 
            switch(curOptor){
                case "*":
                    operRight = operRight * (expr[globIdx++].equals("(") ? compute(expr) : Double.valueOf(expr[globIdx - 1]));
                    break;
                case "/":
                    operRight = operRight / (expr[globIdx++].equals("(") ? compute(expr) : Double.valueOf(expr[globIdx - 1]));
                    break;
                case "+":
                case "-":
                    operLeft = computeTerm(operLeft, lastOptor, operRight);
                    operRight = (expr[globIdx++].equals("(") ? compute(expr) : Double.valueOf(expr[globIdx - 1]));
                    lastOptor = curOptor;
                    break;
            }
            if(curOptor.equals(")")){
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
        ComlexInfixExpr test = new ComlexInfixExpr();
        System.out.println(test.computeInfixExpr("2 * ( 2 - 4 ) - ( ( 3 - 1 ) - ( 3 + 1 ) )"));
    }
}
