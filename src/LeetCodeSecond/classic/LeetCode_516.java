package LeetCodeSecond.classic;

/**
 * @Author: wky233
 * @Date: 2020/9/19 21:14
 * @Description:
 */
public class LeetCode_516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = dp.length - 1; i >= 1; i--) {
            for (int j = i + 1; j < dp.length ; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j-1],dp[i-1][j]));
            }
        }
        return dp[0][dp.length - 1];
    }
}
