package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/8/1 23:30
 * @Description:
 */
public class LeetCode_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        // 完全背包问题 初始化
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = amount; j >= coins[i] ; j--) {
                 dp[j] = dp[j]  + dp[j - coins[i]];
            }
        }
        return dp[dp.length - 1];
    }
}
