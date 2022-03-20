package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/2 10:47
 * @Description:
 */
public class LeetCode_516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        // 状态定义 dp[i][j] 以i开头j形成的最长回文子序列
        int[][] dp = new int[s.length()][s.length()];
        int m = dp.length;
        int n = dp[0].length;
        // 初始化
        for (int i = 0; i < m; i++) {
            dp[i][i] = 1;
        }
        for (int i = m-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }

        }
        return dp[0][m-1];
    }
}
