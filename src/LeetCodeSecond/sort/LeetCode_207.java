package LeetCodeSecond.sort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/8/4 23:07
 * @Description:
 */
public class LeetCode_207 {
    private HashSet<Integer>[] graph;
    private int[] indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashSet[numCourses];
        indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] nums : prerequisites) {
            int from = nums[1];
            int to = nums[0];
            indegree[to]++;
            graph[from].add(to);
        }
        Queue<Integer> queue = new LinkedList<>();
        int courses = numCourses;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            courses--;
            for (int w: graph[poll]) {
                indegree[w]--;
                if (indegree[w] == 0){
                    queue.offer(w);
                }
            }
        }
        return numCourses == 0;
    }
}
