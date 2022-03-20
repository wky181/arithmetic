package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/26 15:03
 * @Description:
 */
public class LeetCode_1558 {
    public int cuttingRope(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            int max = 1;
            for (int j = 1; j < i ; j++) {
                max = j * dp[i - j];
            }
            dp[i] = max;
        }
        return dp[n-1];
    }
}
