package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/28 0:53
 * @Description:
 */
public class LeetCode_474 {
    public static void main(String[] args) {
        String[] strings = {"10","0","1"};

        System.out.println(new LeetCode_474().findMaxForm1(strings,1,1));
    }
    public int[] charCount(String string){
        int[] chars = new int[2];
        char[] chars1 = string.toCharArray();
        for (char ch: chars1) {
            chars[ch - '0'] ++;
        }
        return chars;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null){
            return 0;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int i = 1; i <= strs.length ; i++) {
            int[] count = charCount(strs[i - 1]);
            System.out.println(count[0] +" "+ count[1]);
            for (int j = 0; j <= m ; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j - count[0] >=0 && k - count[1] >=0){
                        dp[i][j][k] = Math.max(dp[i-1][j][k],dp[i-1][j - count[0]][k - count[1]]+1);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
    // 双重背包问题 使用滚动数组，从右到左开始，压缩空间
    public int findMaxForm1(String[] strs, int m, int n) {
        if (strs == null){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length ; i++) {
            int[] count = charCount(strs[i]);
            System.out.println(count[0] +" "+ count[1]);
            for (int j = m; j >= count[0] ; j--) {
                for (int k = n; k >= count[1] ; k--) {
                        dp[j][k] = Math.max(dp[j][k],dp[j - count[0]][k - count[1]]+1);
                }
            }
        }
        return dp[m][n];
    }
}
