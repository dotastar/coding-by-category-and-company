package quantcast.version2;

import java.util.Stack;

public class Cell {

    private SpreadSheet spreadSheet;
    private String[] exprTokens;
    private double exprValue;
    private boolean resolved;
    private Stack<Double> stack;
    private boolean isVisited;

    public Cell(SpreadSheet spreadSheet, String expression) {
        this.spreadSheet = spreadSheet;
        this.exprTokens = expression.split("\\s");
        this.exprValue = 0;
        this.resolved = false;
        this.stack = new Stack<Double>();
        this.isVisited = false;
    }

    public double resolveExpr() throws CyclicDependencyException {
        if (!resolved) {
            if (isVisited) {
                throw new CyclicDependencyException("Cycles in SpreadSheet");
            }
            isVisited = true;
            for (int i = 0; i < this.exprTokens.length; i++) {
                if (isCellRef(this.exprTokens[i])) {
                    Cell childCell = this.getCellRef(this.exprTokens[i]);
                    stack.push(childCell.resolveExpr());
                } else if (isOperator(this.exprTokens[i])) {
                    numericOperation(stack, this.exprTokens[i]);
                } else {
                    stack.push(Double.valueOf(this.exprTokens[i]));
                }
            }
            resolved = true;
            exprValue = stack.pop();
            isVisited = false;
        }
        return exprValue;
    }

    private void numericOperation(Stack<Double> stack, String operator) {
        Double op2 = stack.pop();
        Double op1 = stack.pop();
        switch (operator) {
            case "+":
                stack.push(op1 + op2);
                break;
            case "-":
                stack.push(op1 - op2);
                break;
            case "*":
                stack.push(op1 * op2);
                break;
            case "/":
                stack.push(op1 / op2);
                break;
        }
    }

    private boolean isCellRef(String token) {
        return Character.isLetter(token.charAt(0));
    }

    private boolean isOperator(String token) {
        if (token.matches("[-+*/]")) {
            return true;
        } else {
            return false;
        }
    }

    private Cell getCellRef(String cellRef) {
        int row = cellRef.charAt(0) - 'A';
        int col = cellRef.charAt(1) - '1';
        Cell targetCell = spreadSheet.getCell(row, col);
        return targetCell;
    }

}
