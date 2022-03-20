package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/12 0:01
 * @Description:
 */
public class LeetCode_52 {
    int res = 0;

    public static void main(String[] args) {
        int queens = new LeetCode_52().totalNQueens(4);
        System.out.println(queens);
    }
    public int totalNQueens(int n) {
        if (n <= 0){
            return 0;
        }
        int[][] refer = new int[n][n];
        backtrack(refer,0);
        return res;
    }

    public void backtrack(int[][] refer, int row) {
        if (row == refer.length) {
            res++;
            return;
        }
        for (int i = 0; i < refer.length; i++) {
             if (check(refer,row,i)){
                 //回溯
                 refer[row][i] = 1;
                 backtrack(refer,row+1);
                 refer[row][i] = 0;
             }
        }
    }

    public boolean check(int[][] refer, int row, int clo) {
        //检查列上有没有重复值
        for (int i = 0; i < refer.length; i++) {
            if (refer[i][clo] == 1) {
                return false;
            }
        }
        //检查左上角是否有重复值
        for (int i = row - 1, j = clo - 1; i >= 0 && j >= 0; i--,j--) {
            if (refer[i][j] == 1){
                return false;
            }
        }
        //查右上角是否有重复值
        for (int i = row-1, j = clo +1; i >=0 && j < refer[0].length ; i--, j++) {
            if (refer[i][j] == 1){
                return false;
            }
        }
        return true;
    }

}
