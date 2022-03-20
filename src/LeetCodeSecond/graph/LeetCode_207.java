package LeetCodeSecond.graph;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/7/6 23:58
 * @Description:
 */
public class LeetCode_207 {
    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] indegrees = new int[numCourses];
        // 邻接表
        HashSet<Integer>[] adjSet = new HashSet[numCourses];
        for (int i = 0; i < numCourses ; i++) {
            adjSet[i] = new HashSet<>();
        }
        // 构建邻接表
        for (int[] cp: prerequisites) {
            adjSet[cp[1]].add(cp[0]);
            // 入度+1
            indegrees[cp[0]] += 1;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < numCourses ; i++) {
            if (indegrees[i] == 0){
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            Integer v = deque.poll();
            numCourses--;
            for (int w : adjSet[v]) {
                indegrees[w]--;
                // 入度为零入队
                if (indegrees[w] == 0){
                    deque.offer(w);
                }
            }
        }
        return numCourses == 0;
    }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        // 邻接表
        HashSet<Integer>[] adjSet = new HashSet[numCourses];
        for (int i = 0; i < numCourses ; i++) {
            adjSet[i] = new HashSet<>();
        }
        int[] flag = new int[numCourses];
        for (int[] cp: prerequisites) {
            adjSet[cp[1]].add(cp[0]);
        }
        for (int v = 0; v < numCourses ; v++) {
            if (!dfs(adjSet,v,flag)){
                return false;
            }
        }
        return true;
    }
    private boolean dfs(HashSet<Integer>[] adjSet, int v, int[] flag){
        // 未被DFS过 0
        // 被其他DFS访问过 -1
        // 被当前DFS访问过 1
        if (flag[v] == 1){
            return false;
        }
        // 当前节点已经被其它dfs访问过直接返回true
        if (flag[v] == -1){
            return true;
        }
        flag[v] = 1;
        for (Integer w: adjSet[v]) {
            if (!dfs(adjSet,w,flag)){
                return false;
            }
        }
        // 当前v的 DFS结束 flag[v]置为-1
        flag[v] = -1;
        return true;
    }
}
