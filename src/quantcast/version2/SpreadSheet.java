package quantcast.version2;

import java.util.ArrayList;
import java.util.Scanner;

public class SpreadSheet {
    private int nRows;
    private int nCols;
    private ArrayList<Cell> cells;

    public SpreadSheet(int nRows, int nCols, ArrayList<String> exprList) {
        this.nRows = nRows;
        this.nCols = nCols;
        cells = new ArrayList<Cell>(exprList.size());
        for (String expressionString : exprList) {
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

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String[] metaData = stdin.nextLine().split(" ");
        int nRows = Integer.parseInt(metaData[1]);
        int nCols = Integer.parseInt(metaData[0]);
        ArrayList<String> exprList = new ArrayList<String>();
        for (int i = 0; i < nRows * nCols; i++) {
            exprList.add(stdin.nextLine());
        }
        stdin.close();
        SpreadSheet runner = new SpreadSheet(nRows, nCols, exprList);
        try {
            Double[] res = runner.calculate();
            System.out.println(nCols + " " + nRows);
            for (int i = 0; i < res.length; i++) {
                System.out.println(String.format("%.5f", res[i]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

}
