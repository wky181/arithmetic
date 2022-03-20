package LeetCodeSecond.weekrank;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/19 10:43
 * @Description:
 */
public class LeetCode_6465 {
    HashMap<Integer,Character>[] graph;
    char[] arrays;
    int[] res;
    boolean[] visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new HashMap[n];
        for (int i = 0; i < n ; i++) {
            graph[i] = new HashMap<>();
        }
        visited = new boolean[n];
        arrays = labels.toCharArray();
        buildGraph(edges);
        res = new int[n];
        dfs(0,arrays[0]);
        return res;
    }

    private int dfs(int i, char target) {
        int count = 1;
        visited[i] = true;
        for (int w: graph[i].keySet()) {
            if (!visited[w]){
                if (arrays[w] == target){
                    count += dfs(w,target) + res[w];
                }else {
                    dfs(w,arrays[w]);
                }
            }
        }
        res[i] = count;
        return count;
    }

    private void buildGraph(int[][] edges) {
        for (int[] nums: edges) {
            graph[nums[0]].put(nums[1],arrays[nums[1]]);
            graph[nums[1]].put(nums[0],arrays[nums[0]]);
        }
    }
}
