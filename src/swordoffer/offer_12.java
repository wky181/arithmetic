package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/28 9:27
 * @Description:
 */
public class offer_12 {
    int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return false;
        }
        if (word == null || word.trim().length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                if ( dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int x, int y){
        if (board[x][y] == word.charAt(index)){
            if (index == word.length() - 1){
                return true;
            }else {
                return false;
            }
        }
        char ch = board[x][y];
        board[x][y] = '*';
        for (int i = 0; i < 4 ; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if (jundge(newX, newY, board) && board[newX][newY] != '*' && dfs(board,word,index+1,newX,newY)){
                return true;
            }
        }
        board[x][y] = ch;
        return false;
    }

    public boolean jundge(int x, int y, char[][] board){
        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length){
            return true;
        }else {
            return false;
        }
    }
}
