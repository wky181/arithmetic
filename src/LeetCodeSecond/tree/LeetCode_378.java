package LeetCodeSecond.tree;

import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/7/3 17:14
 * @Description:
 */
public class LeetCode_378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x,y) -> x[0] - y[0]);
        int clo = matrix[0].length;
        for (int i = 0; i < matrix.length ; i++) {
            minHeap.offer(new int[]{matrix[i][0], i , 0});
        }
        for (int i = 0; i < k-1 ; i++) {
            int[] top = minHeap.poll();
            if (top[2] < clo-1 ){
                minHeap.offer(new int[]{matrix[top[1]][top[2]+1],top[1],top[2]+1});
            }
        }
        return minHeap.poll()[0];
    }
}
