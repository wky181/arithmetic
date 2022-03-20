package LeetCodeSecond.dp;


/**
 * @Author: wky233
 * @Date: 2020/7/19 20:32
 * @Description: dp
 */
public class LeetCode_312 {
    public int maxCoins(int[] nums) {
       int[] points = new int[nums.length + 2];
       int n = points.length;
       points[0] = points[n-1] = 1;
        for (int i = 1; i < points.length-1 ; i++) {
            points[i] = nums[i-1];
        }
        int[][] dp = new int[n][n];
        for (int i = dp.length-1; i >= 0 ; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i+1; k < j ; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }
        return dp[0][n-1];
    }
}
