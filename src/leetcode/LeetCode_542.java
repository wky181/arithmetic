package leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 武凯焱
 * @date 2019/12/7 17:41
 * @Description:
 */
public class LeetCode_542 {
    int[][] dir = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = 10000;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (check(matrix, newX, newY) && matrix[newX][newY] == 10000){
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return matrix;
    }

    public boolean check(int[][] matrix, int x, int y) {
        if (x < 0 || x > matrix.length || y > matrix[x].length || y < 0) {
            return false;
        }
        return true;
    }
}
