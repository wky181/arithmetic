package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/11 15:01
 * @Description:
 */
public class LeetCode_130 {
    public void solve(char[][] board) {
        if (board.length == 0){
            return;
        }
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                if (i==0 || j==0 || i == board.length-1 || j == board[i].length-1){
                    if (board[i][j] == 'O' ) {
                        dfs(i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    int[][] help = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public void dfs(int x, int y, char[][] board) {
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
                int newX = x + help[i][0];
                int newY = y + help[i][1];
                if (inAear(newX,newY,board) && board[newX][newY] == 'O' && board[newX][newY] != '#' ){
                    dfs(newX,newY,board);
                }
        }
    }

    public boolean inAear(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length ){
            return false;
        }
        return true;
    }

}
