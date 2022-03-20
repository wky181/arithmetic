package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/29 10:36
 * @Description:
 */
public class offer_14_2 {
    public int cuttingRope(int n) {
        int mod = (int) (1e9 + 7);
        int[] dp = new int[n + 1];
        if (n < 2){
            return n;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = -1;
            for (int j = 0; j < i ; j++) {
                max = Math.max(max, dp[i - j] * j);
                max = Math.max(max, (i - j) * j);
            }
            dp[i] = max % mod;
        }
        return dp[n];
    }
}
