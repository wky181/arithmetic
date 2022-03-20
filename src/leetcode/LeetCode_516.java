package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/18 12:10
 * @Description:
 */
public class LeetCode_516 {
    public static void main(String[] args) {

    }
    public int longestPalindromeSubseq(String s) {
        if (s.length() < 2){
            return s.length();
        }
        int[][] dp = new int[s.length()][s.length()];
        char[] arrays = s.toCharArray();
        for (int i = 0; i < s.length() ; i++) {
            dp[i][i] = 1;
        }
        int len = s.length();
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (arrays[i] == arrays[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }
}
