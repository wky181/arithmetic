package LeetCodeSecond.graph;
import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/8 0:05
 * @Description:
 */
public class LeetCode_785 {
    int[][] adj;
    int[] colors;
    public boolean isBipartite(int[][] graph) {
        adj = graph;
        colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for (int v = 0; v < adj.length ; v++) {
            if (colors[v] == -1) {
                if (!dfs(v, 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    // dfs
    public boolean dfs (int v, int color){
        colors[v] = color;
        for (int w: adj[v]) {
            if (colors[w] == -1){
                if (!dfs(w,1 - color)){
                    return false;
                }
            }else if (colors[w] == color){
                return false;
            }
        }
        return true;
    }
    // bfs
    public boolean bfs (int s){
        colors[s] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()){
            Integer top = queue.poll();
            for (int w: adj[top]) {
                if (colors[w] != -1){
                    colors[w] = 1 - colors[top];
                }else if (colors[w] == colors[top]){
                    return false;
                }
            }
        }
        return true;
    }
}
