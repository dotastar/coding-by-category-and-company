/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   WordSearchPlus.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   WordSearch in 8 directions
 *            
 * All rights reserved.
 ******************************************************************************/
package epic;

public class WordSearchPlus {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (search(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, int i, int j, String s, int idx) {
        if (idx == s.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        board[i][j] = '*';
        boolean res = false;
        for (int k = i - 1; k <= k + 1; k++) {
            for (int m = j - 1; m <= j + 1; m++) {
                if (k != i && m != j) {
                    res = res | search(board, k, m, s, idx + 1);
                }
            }
        }
        return res;
    }
}
