package LeetCodeSecond.classic;

/**
 * @Author: wky233
 * @Date: 2020/9/19 10:52
 * @Description:
 */
public class LeetCode_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int c : coins) {
            for (int i = c; i <= amount; i++) {
                dp[i] += dp[i - c];
            }
        }
        return dp[amount];
    }
}
