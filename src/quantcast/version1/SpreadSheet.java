package quantcast.version1;

import java.util.ArrayList;
import java.util.Scanner;

public class SpreadSheet {
    private int nRows;
    private int nCols;
    private ArrayList<Cell> cells;

    public SpreadSheet(int nRows, int nCols, String... exprArray) {
        this.nRows = nRows;
        this.nCols = nCols;
        cells = new ArrayList<Cell>(exprArray.length);
        for (String expressionString : exprArray) {
            cells.add(new Cell(this, expressionString));
        }
    }

    public Double[] calculate() throws CyclicDependencyException {
        Double[] ans = new Double[cells.size()];
        int i = 0;
        for (Cell cell : cells) {
            ans[i++] = cell.resolveExpr();
        }
        return ans;
    }

    public Cell getCell(int row, int col) {
        return cells.get(row * nCols + col);
    }

    public static class CyclicDependencyException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public CyclicDependencyException(String msg) {
            super(msg);
        }
    }

}
