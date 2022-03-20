package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/30 17:07
 * @Description:
 */
public class LeetCode_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < i ; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
                dp[i] = Math.max(dp[i], j * ( i - j ));
            }
        }
        return dp[n];
    }
}
