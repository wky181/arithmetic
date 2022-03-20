package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/23 21:43
 * @Description:
 */
public class LeetCdoe_516 {
    public int longestPalindromeSubseq(String s) {
        char[] array = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];
        // 状态定义 i ~ j 范围内最长回文子序列
        for (int i = 0; i < s.length() ; i++) {
            dp[i][i] = 1;
        }
        for (int i = dp.length-1; i >= 0; i--) {
            for (int j = i+1; j < dp.length ; j++) {
                if (array[i] == array[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
