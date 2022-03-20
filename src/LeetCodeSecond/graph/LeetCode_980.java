package LeetCodeSecond.graph;

import java.util.ArrayList;

/**
 * @Author: wky233
 * @Date: 2020/7/9 13:45
 * @Description:
 */
public class LeetCode_980 {
    private int C;
    private int R;
    private int start;
    private int end;
    private int left;
    private int visited;
    private int[][] grid;
    private int[][] dirs = {
            {1,0},
            {-1,0},
            {0,1},
            {0, -1}
    };
    public int uniquePathsIII(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        this.grid = grid;
        visited = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C ; j++) {
                if (grid[i][j] == 1){
                    start = i * C + j;
                    left++;
                }
                else if (grid[i][j] == 2){
                    end = i * C + j;
                    grid[i][j] = 0;
                }else if (grid[i][j] == 0){
                    left++;
                }
            }
        }
       return dfs(start);
    }

    private int dfs(int v) {
        // 求路径
        if (v == end && left == 0){
            return 1;
        }
        int res = 0;
        visited += (1 << v);
        left--;
        int x = v / C;
        int y = v % C;
       // ArrayList<Integer> nexts = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            int next = nextX * C + nextY;
            if (((visited & (1 << next)) == 0) && isVaild(nextX,nextY) && grid[nextX][nextY] == 0){
                res += dfs(next);
            }
        }
        // 回溯
        visited -= (1 << v);
        left++;
        return res;
    }
    private boolean isVaild(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
