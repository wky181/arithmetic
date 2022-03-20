package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/28 12:09
 * @Description:
 */
public class LeetCode_1492 {
    public int waysToChange(int n) {
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length ; i++) {
            for (int j = coins[i]; j <= n ; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }
}
