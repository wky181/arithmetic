package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/20 15:04
 * @Description:
 */
public class LeetCode_463 {
    int[][] dir = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    int res = 0;

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int x, int y) {

        for (int i = 0; i < 4 ; i++) {
            int newX = x + grid[i][0];
            int newY = y + grid[i][1];
            if (!jundge(grid,newX,newY) || grid[newX][newY] == 0){
                res+=1;
            }else {
                dfs(grid,newX,newY);
            }
        }
    }
    public boolean jundge(int[][] grid, int x, int y){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return false;
        }
        return true;
    }
}
