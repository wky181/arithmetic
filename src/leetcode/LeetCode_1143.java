package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/30 20:15
 * @Description:
 */
public class LeetCode_1143 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1143().longestCommonSubsequence("abcde", "ace"));
    }

    int[][] memo;

    //递归加记忆化搜索
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        return slove(text1.toCharArray(), text2.toCharArray(), text1.length() - 1, text2.length() - 1);
    }

    public int slove(char[] text1, char[] text2, int indexA, int indexB) {
        if (indexA < 0 || indexB < 0) {
            return 0;
        }
        if (memo[indexA][indexB] != -1) {
            return memo[indexA][indexB];
        }
        if (text1[indexA] == text2[indexB]) {
            int res = slove(text1, text2, indexA - 1, indexB - 1) + 1;
            memo[indexA][indexB] = res;
            return res;
        } else {
            int res = Math.max(slove(text1, text2, indexA - 1, indexB), slove(text1, text2, indexA, indexB - 1));
            memo[indexA][indexB] = res;
            return res;
        }
    }

    //dp 自底向上
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] charsA = text1.toCharArray();
        char[] charsB = text2.toCharArray();
        int[][] memo = new int[charsA.length + 1][charsB.length + 1];

        for (int i = 1; i <= charsA.length; i++) {
            for (int j = 1; j <= charsB.length; j++) {
                if (charsA[i - 1] == charsB[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
                }
            }
        }
        return memo[charsA.length][charsB.length];
    }

    // 动态规划来做
    public int longestCommonSubsequence3(String text1, String text2) {
        if (text1 == null || text2 == null || text1.equals("") || text2.equals("")){
            return 0;
        }
        char[] array1 = text1.toCharArray();
        char[] array2 = text2.toCharArray();
        int[][] dp = new int[array1.length + 1][array2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[array1.length][array2.length];
    }


}
