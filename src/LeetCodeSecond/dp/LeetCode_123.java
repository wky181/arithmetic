package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/28 23:34
 * @Description:
 */
public class LeetCode_123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2){
            return 0;
        }
        // dp[i][j] 表示[0,i]区间里，状态为j的最大收益
        // j = 0 什么都不操作
        // j = 1 第一次买入股票
        // j = 2 第一次卖出一支股票
        // j = 3 第二次买入一支股票
        // j = 4 第二次卖出一支股票

        // 初始化
        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 3 状态都还没有发生，因此赋一个不可能的值
        for (int i = 0; i < len ; i++) {
            dp[i][3] = Integer.MIN_VALUE;
        }

        // 状态转移只有两种情况：
        // 1、什么都不做
        // 2、由上一个状态转移过来的
        for (int i = 1; i < len ; i++) {
            // j = 0的值永远是 0
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }
        return Math.max(0, Math.max(dp[len-1][2], dp[len-1][4]));
    }
    // 压缩空间
    public int maxProfit1(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[][] dp = new int[2][5];
        dp[0][1] = -prices[0];
        dp[0][3] = Integer.MIN_VALUE;
        dp[1][3] = Integer.MIN_VALUE;
        // 0表示什么也没有做
        // 1表示第一次买入股票
        // 2表示第一次卖出股票
        // 3表示第二次买入股票
        // 4表示第二次卖出股票
        for (int i = 1; i < prices.length ; i++) {
            int index = (i % 2 ) == 0 ? 1 : 0;
            dp[i % 2][1] = Math.max(dp[index][1], dp[index][0] - prices[i]);
            dp[i % 2][2] = Math.max(dp[index][2], dp[index][1] + prices[i]);
            dp[i % 2][3] = Math.max(dp[index][3], dp[index][2] - prices[i]);
            dp[i % 2][4] = Math.max(dp[index][4], dp[index][3] + prices[i]);
        }
        int res = 0;
        for (int[] nums: dp) {
            res = Math.max(Math.max(res,nums[2]), nums[4]);
        }
        return res;
    }
    // 看成两个股票1问题
    // 从左到右遍历一遍，记录每个位置的左边子数组的股票交易的最大收益
    // 从右遍历一遍，记录每个位置右边子数组的股票交易最大收益
    // 然后再遍历一遍，找最佳分割点
    public int maxProfit2(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int[] left = new int[prices.length];
        int minValue = prices[0];
        for (int i = 1; i < prices.length ; i++) {
            left[i] = Math.max(left[i-1],prices[i] - minValue);
            minValue = Math.min(prices[i], minValue);
        }
        int[] right = new int[prices.length];
        int maxValue = prices[prices.length-1];
        for (int i = prices.length - 2; i >= 0 ; i--) {
            right[i] = Math.max(right[i+1],maxValue - prices[i]);
            maxValue = Math.max(prices[i], maxValue);
        }
        // 枚举间隙
        // 一次交易情况也考虑
        int res = Math.max(left[prices.length-1], right[0]);
        for (int i = 1; i < prices.length - 2 ; i++) {
            res = Math.max(res,left[i] + right[i+1]);
        }
        return res;
    }
}
