package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/10 20:18
 * @Description:
 */
public class LeetCode_79 {
    public static void main(String[] args) {

      //  new LeetCode_79().exist()
    }

    int[][] help = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        visit = new boolean[board.length][board[0].length];
        char[] arrays = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board,0,arrays,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean inAera(char[][] board, int x, int y){
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return false;
        }
        return true;
    }

    public boolean dfs(char[][] board, int index, char[] words, int x, int y) {
        if (index == words.length ){
            return true;
        }
        if (board[x][y] == words[index]) {
            visit[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = x + help[i][0];
                int newY = y + help[i][1];
                if (inAera(board, newX, newY) && !visit[newX][newY] && dfs(board, index + 1, words, newX, newY)) {
                    return true;
                }
            }
            visit[x][y] = false;

        }
        return false;
    }
}
