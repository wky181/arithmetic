package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/8 23:18
 * @Description:
 */
public class LeetCode_16_1_1 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0){
            return new int[]{};
        }
        if (shorter == longer){
            int[] res = new int[1];
            res[0] = shorter * k;
            return res;
        }
        int[] dp = new int[k+1];
        // 初始化
        dp[0] = k * shorter;
        for (int i = 1; i < dp.length ; i++) {
            dp[i] = dp[i-1] - shorter + longer;
        }
        return dp;
    }
}
