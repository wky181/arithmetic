package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/1 23:24
 * @Description:
 */
public class LeetCode_718 {
    public int findLength(int[] A, int[] B) {
        //状态定义A 的i个和 b的前j个 并且以i,j结尾所构成的公共数组的最大长度
        int max = 1;
        int[][] dp  = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < dp.length ; i++) {
            for (int j = 1; j < dp[i].length ; j++) {
                if (A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
