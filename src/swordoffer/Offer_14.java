package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/29 9:40
 * @Description:
 */
public class Offer_14 {
    int[] memo;
    public int cuttingRope(int n) {
        memo = new int[n+1];
        return cut(n);
    }
    public int cut(int n) {
        if (n == 1){
            return 1;
        }else if (memo[n] != 0){
            return memo[n];
        }
        int max = -1;
        for (int i = 1; i < n ; i++) {
            int cutMax = Math.max(cut(n - i) * i, (n - i) * i);
            max = Math.max(max, cutMax);
        }
        memo[n] = max;
        return max;
    }

    public int cuttingRope1(int n) {
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
        }
        return dp[n];
    }
    public static void main(String[] args) {
        new Offer_14().cuttingRope(10);
    }
}
