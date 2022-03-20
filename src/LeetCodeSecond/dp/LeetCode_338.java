package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/11 0:28
 * @Description:
 */
public class LeetCode_338 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // i是奇数 dp[i] = dp[i-1] + 1
            if ((i & 1) == 1) {
                dp[i] = dp[i - 1] + 1;
            }else{
                // i是偶数
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }
}
