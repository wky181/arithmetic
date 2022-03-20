package LeetCodeSecond.offer2;

/**
 * @Author: wky233
 * @Date: 2020/9/15 20:50
 * @Description:
 */
public class offer19 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // dp[i][j]表示s的前i个和p的前j个能否匹配
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                // 如果正则表达式为空
                if (j == 0){
                    dp[i][j] = i == 0;
                }else {
                    if (p.charAt(j - 1) != '*'){
                        if ( i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')){
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }else {
                        // 匹配0个
                        if (j >= 2){
                            dp[i][j] = dp[i][j - 2];
                        }
                        // 正则串不动，主串向前挪一步
                        if (i > 0 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
