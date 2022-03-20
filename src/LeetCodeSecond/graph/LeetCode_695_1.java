package LeetCodeSecond.graph;

import java.util.TreeSet;

/**
 * @Author: wky233
 * @Date: 2020/7/8 13:42
 * @Description:
 */
public class LeetCode_695_1 {
    private int R;
    private int C;
    private int[][] dirs = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    private int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        this.grid = grid;
        int maxRes = 0;
        R = grid.length;
        C = grid[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C ; j++) {
                if (grid[i][j] == 1){
                    maxRes = Math.max(maxRes,dfs(i,j));
                }
            }
        }
        return maxRes;
    }
    private int dfs(int x, int y){
        int res = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4 ; i++) {
            int nextx = x + dirs[i][0];
            int nexty = y +  dirs[i][1];
            if (isVilad(nextx,nexty) && grid[nextx][nexty] == 1){
                res += dfs(nextx, nexty);
            }
        }
        return res;
    }

    private boolean isVilad(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
