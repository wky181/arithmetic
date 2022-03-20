package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/8 10:22
 * @Description:
 */
public class LeetCode_221 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1){
                    dp[i+1][j+1] = min(dp[i][j+1],dp[i+1][j],dp[i][j]) + 1;
                    res = Math.max(res, dp[i+1][j+1]);
                }
            }
        }
        return dp[matrix.length+1][matrix[0].length+1];
    }
    public int min (int a, int b, int c){
        int min = Math.min(a, b);
        return Math.min(min, c);
    }
}
