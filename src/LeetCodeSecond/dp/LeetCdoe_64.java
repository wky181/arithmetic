package LeetCodeSecond.dp;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/23 8:36
 * @Description:
 */
public class LeetCdoe_64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 转移方程 dp[i][j] += Math.min(dp[i+1][j],dp[i][j+1])
        int[][] dp = new int[m+1][n+1];
        for (int[] nums : dp) {
            Arrays.fill(nums,Integer.MAX_VALUE);
        }
        // 初始化
        dp[m-1][n] = 0;
        dp[m][n-1] = 0;
        for (int i = dp.length - 1; i >= 0 ; i--) {
            for (int j = dp[i].length-1; j >=0 ; j--) {
                dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[0][0];
    }
}
