package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/10 22:51
 * @Description:
 */
public class LeetCode_200 {
    public static void main(String[] args) {
        char[][] w ={{'1','1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};
        System.out.println(new LeetCode_200().numIslands(w));

    }
    int[][] help = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    boolean[][] visit;
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0){
            return 0;
        }
        visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length ; j++) {
                    if (grid[i][j] == '1' && !visit[i][j]){
                        res++;
                        dfs(grid,i,j);
                    }
            }
        }
        return res;
    }
    public boolean inAera(char[][] board, int x, int y){
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return false;
        }
        return true;
    }
    public void dfs(char[][] grid, int x, int y){

        visit[x][y] = true;
        for (int i = 0; i < 4 ; i++) {
            int newX = x +help[i][0];
            int newY = y + help[i][1];
            if (inAera(grid,newX,newY) && !visit[newX][newY] && grid[newX][newY] == '1'){
                dfs(grid,newX,newY);
            }
        }
    }
}
