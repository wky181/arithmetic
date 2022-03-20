package demo;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/9/27 20:07
 * @Description:
 */
public class wy1 {
    public int method(int[] nums, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, m + 1);
        dp[0] = 0;
        for (int c: nums) {
            for (int i = c; i <= m ; i++) {
                dp[i] = Math.min(dp[i - c] + 1, dp[i]);
            }
        }
        if (dp[m] == m + 1){
            dp[m] = -1;
        }
        return dp[m];
    }
}
