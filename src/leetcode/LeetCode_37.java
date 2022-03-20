package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/4/12 16:56
 * @Description:
 */
public class LeetCode_37 {
    int[][] rows;
    int[][] clos;
    int[][] boxs;

    public void solveSudoku(char[][] board) {
        rows = new int[9][9];
        clos = new int[9][9];
        boxs = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int index = (i / 3) * 3 + j / 3;
                    rows[i][num]++;
                    clos[j][num]++;
                    boxs[index][num]++;
                }
            }
        }
        backtrace(board,0,0);
    }

    public boolean backtrace(char[][] board, int row, int clo) {
        if (clo == board.length){
            return backtrace(board,row+1,0);
        }
        if (row == board.length){
            return true;
        }
        if (board[row][clo] == '.') {
            for (char i = '1'; i <= '9'; i++) {
                if (check(board, row, clo, i)) {
                    board[row][clo] = i;
                    int index = (row/3)*3 + clo/3;
                    rows[row][i - '1'] += 1;
                    clos[clo][i - '1'] += 1;
                    boxs[index][i - '1'] += 1;
                    // 如果找到了可行解不再dfs
                    if (backtrace(board, row, clo + 1)){
                        return true;
                    }
                    rows[row][i - '1'] -= 1;
                    clos[clo][i - '1'] -= 1;
                    boxs[index][i - '1'] -= 1;
                    board[row][clo] = '.';
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, int row, int clo, char ch) {
        int index = (row / 3) * 3 + clo / 3;
        if (rows[row][ch] > 0 || clos[clo][ch] > 0 || board[index][ch] > 0) {
            return false;
        }
        return true;
    }
}
