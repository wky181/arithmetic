package LeetCodeSecond.classic;

/**
 * @Author: wky233
 * @Date: 2020/9/18 10:37
 * @Description:
 */
public class LeetCode_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int l = 0;
        int r = 0;

        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        for (int i = 1; i < dp.length ; i++) {
            dp[i][i] = true;
        }
        for (int i = dp.length-2; i >= 1 ; i--) {
            for (int j = i + 1; j < dp.length ; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i + 1][j - 1];
                }else {
                    dp[i][j] = false;
                }
                if (dp[i][j] && j - i > r - l){
                    r = j;
                    l = i;
                }
            }
        }
        return s.substring(l, r);
    }
}
