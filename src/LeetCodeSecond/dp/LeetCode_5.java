package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/22 23:00
 * @Description:
 */
public class LeetCode_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] array = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() ; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                 if (array[i] == array[j]){
                     if (j - i == 1){
                         dp[i][j] = true;
                     }else {
                         dp[i][j] = dp[i+1][j-1];
                     }
                     if (dp[i][j] && j - i > end - start){
                         start = i;
                         end = j;
                     }
                 }else {
                     dp[i][j] = false;
                 }
            }
        }
        return s.substring(start,end+1);
    }
}
