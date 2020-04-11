package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/15 14:31
 * @Description:
 */
public class LeetCode_122 {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(new LeetCode_122().maxProfit(nums));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int dp_0 = 0;
        int dp_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_0 = Math.max(dp_1 + prices[i], dp_0);
            dp_1 = Math.max(dp_1, dp_0 - prices[i]);
        }
        return dp_0;
    }
    public  int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length ; i++) {
            if (prices[i-1] < prices[i]){
                res +=  prices[i] - prices[i-1];
            }
        }
        return res;
    }
}
