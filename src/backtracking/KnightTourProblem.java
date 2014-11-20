/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   KnightTourProblem.java
 *         Created:   Nov 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   The knight is placed on the first block of an empty board and,
 *                    moving according to the rules of chess, must visit each square exactly once.
 *                    knight can move 8 directions at one step
 * All rights reserved.
 ******************************************************************************/
package backtracking;

public class KnightTourProblem {
    public boolean exist(int[][] board) {
        if (search(board, 0, 0, 0, board.length * board[0].length)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean search(int[][] board, int i, int j, int idx, int len) {
        if (idx == len) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == -1) {
            return false;
        }
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k != i || l != j) {
                    board[i][j] = -1;
                    if (search(board, k, l, idx + 1, len)) {
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
        }
        return true;
    }
}
