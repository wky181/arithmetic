package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/3/29 23:54
 * @Description:
 */
public class LeetCode_1162 {
    public static void main(String[] args) {

    }

    public int maxDistance(int[][] grid) {
        int[] xnums = {0, 0, -1, 1};
        int[] ynums = {-1, 1, 0, 0};
        boolean isHai = false;
        Queue<int[]> queue = new LinkedList<>();
        //先将所有陆地都入队
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[] point = new int[2];
        while (!queue.isEmpty()) {
            int[] nums = queue.poll();
            //每个陆地上下左右扩散找海洋
            for (int i = 0; i < 4; i++) {
                int x = nums[0] + xnums[i];
                int y = nums[1] + ynums[i];
                //grid[x][y] != 0，该题是无线图需要记录访问过的结点，访问过则无需再次访问
                if (x<0 || x >= grid.length || y <0 || y >= grid[0].length || grid[x][y] != 0){
                    continue;
                }
                isHai = true;
                point[0] = x;
                point[1] = y;
                //直接修改原数组，记录起始陆地到达该海洋的距离
                grid[x][y] = grid[nums[0]][nums[1]] +1 ;
                queue.offer(new int[] {x,y});
            }
        }
        return isHai ? grid[point[0]][point[1]]-1 : -1;
    }
}
