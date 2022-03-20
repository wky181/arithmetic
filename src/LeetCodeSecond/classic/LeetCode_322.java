package LeetCodeSecond.classic;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/9/18 23:36
 * @Description:
 */
public class LeetCode_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int c: coins) {
                if (i - c >= 0 && dp[i - c] != amount + 1){
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        if (dp[amount] == amount  + 1){
            dp[amount] = -1;
        }
        return dp[amount];
    }
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int c: coins) {
            for (int i = c; i <= amount ; i++) {
                dp[i] = Math.max(dp[i - c] + 1, dp[i]);
            }
        }
        if (dp[amount] == amount + 1){
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
