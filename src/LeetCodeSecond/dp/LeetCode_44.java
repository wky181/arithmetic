package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/5 10:10
 * @Description:
 */
public class LeetCode_44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int m = s.length() + 1;
        int n = p.length() + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    if (p.charAt(j-1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || s.charAt(j - 1) == '?')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else {
                        // 失配情况
                        dp[i][j] = dp[i][j-1];
                        if (i > 0){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
