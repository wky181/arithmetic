package leetcode;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/3/22 16:11
 * @Description:
 */
public class LeetCode_63 {
    public static void main(String[] args) {
        int[][] nums = {
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,0,0,0}
        };

        System.out.println(uniquePathsWithObstacles(nums));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length ; i++) {
            for (int j = 0; j < obstacleGrid[0].length ; j++) {
                if (i == 0 && j > 0){
                    obstacleGrid[0][j] = obstacleGrid[0][j] == 1  ? 0 : obstacleGrid[0][j-1] ;
                }else if (j == 0 && i > 0){
                    obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i-1][0] ;
                }else if (i>0){
                    if (obstacleGrid[i][j] == 1){
                        obstacleGrid[i][j] = 0;
                    }else {
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                    }
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static int dfs(int x, int y, int[][] nums) {
        if (x >= nums.length || y >= nums[0].length) {
            return 0;
        }
        else if (x == nums.length-1 && y == nums[0].length-1 && nums[x][y] != 1 ){
            return 1;
        }else if (nums[x][y] == 1) {
            return 0;
        }
        int res =  dfs(x + 1, y, nums) + dfs(x, y + 1, nums) ;
        if (res == 0){
            nums[x][y] = 1;
        }
        return res;
    }
}
