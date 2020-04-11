package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/20 9:49
 * @Description:
 */
public class LeetCode_64 {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0 ) {
                    grid[0][j] += grid[0][j - 1];
                } else if (j == 0) {
                    grid[i][0] += grid[i - 1][0];
                } else {
                    grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length-1];
    }
}
