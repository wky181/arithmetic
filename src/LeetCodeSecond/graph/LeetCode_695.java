package LeetCodeSecond.graph;
import java.util.TreeSet;

/**
 * @Author: wky233
 * @Date: 2020/7/8 9:27
 * @Description:
 */
public class LeetCode_695 {
    private int R;
    private int C;
    private TreeSet<Integer>[] adj;
    private boolean visited[];
    private int V;
    private int[][] dirs = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int maxRes = 0;
        R = grid.length;
        C = grid[0].length;
        V = R * C;
        // 二维数组映射为一维数组
        adj = new TreeSet[R * C];
        visited  = new boolean[V];
        for (int i = 0; i < adj.length ; i++) {
            adj[i] = new TreeSet<>();
        }
        constructGraph(grid);
        for (int v = 0; v < V ; v++) {
            if (!visited[v] &&  grid[v / C ][v % C] == 1){
                maxRes = Math.max(maxRes,dfs(v));
            }
        }
        return maxRes;
    }

    private void constructGraph(int[][] grid) {
        for (int v = 0; v < V ; v++) {
            // 一维数组映射为二维数组
            int x = v / C;
            int y = v % C;
            if (grid[x][y] == 1){
                for (int i = 0; i < 4 ; i++) {
                    int nextx = x + dirs[i][0];
                    int nexty = y + dirs[i][1];
                    if (isVilad(nextx,nexty) && grid[nextx][nexty] == 1){
                        int next = nextx * C + nexty;
                        adj[v].add(next);
                        adj[next].add(v);
                    }
                }

            }
        }
    }
    private int dfs(int v){
        int res = 0;
        visited[v] = true;
        for (int w: adj[v]) {
            if (!visited[w]){
                res += dfs(w);
            }
        }
        return res;
    }

    private boolean isVilad(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
