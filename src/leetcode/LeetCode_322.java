package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/9 23:15
 * @Description:
 */
public class LeetCode_322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins,11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
