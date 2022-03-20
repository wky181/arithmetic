package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/4/12 16:56
 * @Description:
 */
public class LeetCode_36 {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] clos = new HashMap[9];
        HashMap<Integer, Integer>[] boxs = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            clos[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    // 查看改点在本列和本行以及所在的box中有没有重复
                    rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                    clos[j].put(num, clos[j].getOrDefault(num, 0) + 1);
                    boxs[boxIndex].put(num, boxs[boxIndex].getOrDefault(num, 0) + 1);
                    if (rows[i].get(num) > 1 || clos[j].get(num) > 1 || boxs[boxIndex].get(num) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    // 用数组替代hashmap
    public boolean isValidSudoku1(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] clos = new int[9][9];
        int[][] boxs = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    // 查看改点在本列和本行以及所在的box中有没有重复
                    rows[i][num] += 1;
                    clos[j][num] += 1;
                    boxs[boxIndex][num] += 1;
                    if (rows[i][num] > 1 ||rows[j][num] > 1 || boxs[boxIndex][num] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
