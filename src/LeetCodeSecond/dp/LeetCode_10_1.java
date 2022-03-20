package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/5 9:24
 * @Description:
 */
public class LeetCode_10_1 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        int m = s.length() + 1;
        int n = p.length() + 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0){
                    dp[i][j] = i == 0;
                }else{
                    if (p.charAt(j - 1) != '*'){
                        if (i > 0 && (s.charAt(i-1) == s.charAt(j-1) || p.charAt(j-1) == '.')){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else {
                        // 直接失配的情况
                        if (j >= 2){
                            dp[i][j] = dp[i][j-2];
                        }
                        // *匹配多次
                        if (i > 0 && j > 1 && (s.charAt(i-1) == p.charAt(j-2) || s.charAt(j-2) == '.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
