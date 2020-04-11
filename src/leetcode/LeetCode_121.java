package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/10 21:06
 * @Description:
 */
public class LeetCode_121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        if (prices != null && prices.length <= 0) {
            return 0;
        }
        int dp_0 = 0;
        int dp_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_0 = Math.max(dp_1 + prices[i], dp_0);
           dp_1 = Math.max(dp_1, -prices[i]);
        }
        return dp_0;
    }

}
