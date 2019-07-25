package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/4/15 21:33
 * @Description:
 */
/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

        示例:

        X X X X
        X O O X
        X X O X
        X O O X
        运行你的函数后，矩阵变为：

        X X X X
        X X X X
        X X X X
        X O X X
        解释:
X O X O X O
O X O X O X
X O X O X O
O X O X O X
        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
*/
public class 被围绕的区域 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] board = new char[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m; j++) {
               board[i][j] = scanner.next().charAt(0);
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        solve(board);
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solve(char[][] board) {
        if (board.length<=0){
            return;
        }
        boolean[][] booleans = new boolean[board.length][board[0].length];
        for (int i = 0; i <booleans.length ; i++) {
            Arrays.fill(booleans[i],true);
        }
        for (int i = 0; i < board.length ; i++) {
               if (board[i][0] == 'O'){
                   dfs(i,0,board,booleans);
               }
               if (board[i][board[0].length-1]=='O'){
                   dfs(i,board[0].length-1,board,booleans);
               }
        }
        for (int i = 0; i <board[0].length ; i++) {
            if (board[0][i]=='O'){
                dfs(0,i,board,booleans);
            }
            if (board[board.length-1][i]=='O'){
                dfs(board.length-1,i,board,booleans);
            }
            
        }
        for (int i = 1; i <board.length-1 ; i++) {
            for (int j = 1; j <board[0].length-1 ; j++) {
                if (board[i][j]=='O'&& booleans[i][j]){
                    board[i][j]= 'X';
                }
            }
        }
    }

    public static void dfs(int i ,int j, char[][] board , boolean[][] booleans){
        booleans[i][j] = false;
        for (int k = -1; k < 2 ; k++) {
            if (k!=0){
                if (i+k>=0&&i+k<board.length){
                    if (board[i+k][j]=='O' && booleans[i+k][j]){
                        dfs(i+k,j,board,booleans);
                    }
                }
                if (k+j>=0&&k+j<board[0].length){
                    if (board[i][j+k]=='O' && booleans[i][j+k]){
                        dfs(i,j+k,board,booleans);
                    }
                }

            }
        }
    }

}
