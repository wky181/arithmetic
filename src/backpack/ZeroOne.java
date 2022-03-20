package backpack;

/**
 * @Author: wky233
 * @Date: 2020/8/1 16:49
 * @Description: 01背包
 */
public class ZeroOne {
    // 自底向上求01背包问题 二维数组
    public static int dp2(int[] w, int[] v, int c) {
        int[][] dp = new int[w.length + 1][c + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 不选
                dp[i][j] = dp[i - 1][j];
                // 选
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
    // 自底向上求01背包问题 一维数组
    public static int dp1(int[] w, int[] v, int c) {
        int[] dp = new int[c + 1];
        int m = c;
        for (int i = 0; i < w.length; i++) {
            for (int j = m; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[dp.length - 1];
    }
    public static void main(String[] args) {
        int[] w = {1,2,3,4};
        int[] v = {2,4,4,5};
        int captiy = 5;
        System.out.println(dp2(w, v, captiy));
        System.out.println(dp1(w, v, captiy));
    }
}
