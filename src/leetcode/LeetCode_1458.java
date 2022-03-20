package leetcode;


import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/5/28 10:01
 * @Description:
 */
public class LeetCode_1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        Arrays.fill(dp[0],-10001);
        for (int i = 0; i < dp.length ; i++) {
            dp[i][0] = -10001;
        }
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[i].length ; j++) {
                dp[i][j] = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + dp[i][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
            }

        }
        return dp[nums1.length][nums2.length];
    }
}
