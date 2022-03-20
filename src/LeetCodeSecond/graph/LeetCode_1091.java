package LeetCodeSecond.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/7/8 14:19
 * @Description:
 */
public class LeetCode_1091 {
    private int R;
    private int C;
    // 方向
    private int[][] dirs = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
            {1,1},
            {-1,-1},
            {-1,1},
            {1,-1}
    };
    public int shortestPathBinaryMatrix(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int[][] dis = new int[R][C];
        if (grid[0][0] == 1){
            return -1;
        }
        if (R == 1 && C ==1){
            return 1;
        }
        if (grid[R - 1][C-1] != 0){
            return -1;
        }
        dis[0][0] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int v = queue.poll();
            int x = v  / C;
            int y = v % C;
            int distance = dis[x][y];
            for (int i = 0; i < 8 ; i++) {
                int nextX= x + dirs[i][0];
                int nextY = y + dirs[i][1];
                if (isVaild(nextX,nextY) && grid[nextX][nextY] == 0 && !visited[nextX][nextY] ){
                    // 二维数组映射为一维数组
                    int next = nextX * C + nextY;
                    queue.offer(next);
                    dis[nextX][nextY] = distance + 1;
                    visited[nextX][nextY] = true;
                    if (nextX == R - 1 && nextY == C - 1){
                        return  dis[nextX][nextY];
                    }

                }
            }
        }
        return -1;
    }
    public boolean isVaild(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
     }
}
