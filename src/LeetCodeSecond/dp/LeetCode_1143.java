package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/23 22:16
 * @Description:
 */
public class LeetCode_1143 {
    public static void main(String[] args) {

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        char[] textArray = text1.toCharArray();
        char[] textBarray = text2.toCharArray();
        // 状态定义 i表示text1的结尾 j表示text2的结尾
        // dp[i][j] i以及前面的的字符串 与j以及前面的字符串
        // dp[i][j] 表示以及前面的的字符串 与j以及前面的字符串的最长公共子序列
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (textArray[i-1] == textBarray[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
