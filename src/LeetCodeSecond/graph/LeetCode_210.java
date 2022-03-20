package LeetCodeSecond.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/7/7 10:00
 * @Description:
 */
public class LeetCode_210 {
    // BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] inDegree  = new int[numCourses];
        int[] res = new int[numCourses];
        int index =  0;
        // 邻接表
        HashSet<Integer>[] adjSet = new HashSet[numCourses];
        // 实例化
        for (int i = 0; i < numCourses ; i++) {
            adjSet[i] = new HashSet<>();
        }
        // 构建邻接表
        for (int[] cp : prerequisites) {
            adjSet[cp[1]].add(cp[0]);
            inDegree[cp[0]]++;
        }
        Deque<Integer> deque = new ArrayDeque<>(numCourses);
        for (int i = 0; i < numCourses ; i++) {
            if (inDegree[i] == 0){
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            Integer v = deque.poll();
            res[index++] = v;
            for (int w : adjSet[v]) {
                if (--inDegree[w] == 0){
                    deque.offer(w);
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }

}
