package yelp;

public class SearchInSortedRowAndColMatrix {
    public boolean findLinear(int[][] matrix, int elem) {
        int row = 0, col = matrix[0].length - 1;//NOTE think why col need start from matrix[0].length - 1?
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == elem) {
                return true;
            } else if (matrix[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
