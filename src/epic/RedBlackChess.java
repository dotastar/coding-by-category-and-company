/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RedBlackChess.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   If 3 respective marks together(no mater: vertical, horizontal, diagonal ) will win 1 point; 
 *                    For user X, 6 respective marks together will win 4 points; 
 *                    For user O, 8 respective marks together will win 6 points, check who win.
 *                    
 * All rights reserved.
 ******************************************************************************/
package epic;

public class RedBlackChess {
    public int[] Winner(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            throw new IllegalArgumentException("grid should be two deminsional");
        int rows = grid.length, cols = grid[0].length;
        int[] scores = new int[2];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int id = grid[r][c] == 'X' ? 0 : 1;
                if (r + 2 < rows) {
                    if(checkSameLine(grid[r][c], grid[r + 1][c], grid[r + 2][c])){
                        scores[id]++;
                    }
                    if(c + 2 < cols && checkSameLine(grid[r][c], grid[r + 1][c + 1], grid[r + 2][c + 2])){
                        scores[id]++;
                    }
                    if(c - 2 >= 0 && checkSameLine(grid[r][c], grid[r + 1][c - 1], grid[r + 2][c - 2])){
                        scores[id]++;
                    }
                }
                if (c + 2 < cols) {
                    if (checkSameLine(grid[r][c], grid[r][c + 1], grid[r][c + 2])){
                        scores[id]++;
                    }
                }
            }
        }
        if (scores[0] == scores[1]) {
            System.out.println("Draw");
        } else if (scores[0] > scores[1]) {
            System.out.println("X is winner");
        } else {
            System.out.println("O is winner");
        }
        return scores;
    }
    
    public boolean checkSameLine(char a, char b, char c) {
        if(a == b && b ==c ){
            return true;
        }else{
            return false;
        }
    }

}
