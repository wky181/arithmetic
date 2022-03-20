package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/21 22:32
 * @Description:
 */
public class LeetCode_647 {
    public int countSubstrings(String s) {
        char[] array = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length() ; i++) {
            dp[i][i] = true;
        }
        int count = s.length();
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i+1; j < dp[0].length ; j++) {

                if (array[i] == array[j]){
                    if (j - i == 1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j]){
                        count++;
                    }
                }else {
                    dp[i][j] = false;
                }
            }
        }
        return count;
    }
}
