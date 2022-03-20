package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/5/17 21:31
 * @Description:
 */
public class LeetCode_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] course: prerequisites ) {
            int dest = course[1];
            int src = course[0];
            List<Integer> lst = map.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            map.put(src,lst);
        }
        int[] visited = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses ; i++) {
            if (!dfs(i,map,visited,ans)){
                return new int[0];
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    private boolean dfs(int node, Map<Integer, List<Integer>> map, int[] visited, List<Integer> ans){
        if (visited[node] == 2){
            return true;
        }
        if (visited[node] == 1 ){
            return false;
        }
        visited[node] = 1;
        if (!map.containsKey(node)){
            ans.add(node);
            visited[node] = 2;
            return true;
        }
        List<Integer> list = map.get(node);
        for (Integer src : list ) {
            if (!dfs(src,map,visited,ans)){
                return false;
            }
        }
        visited[node] = 2;
        ans.add(node);
        return true;
    }
}
