package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/15 15:07
 * @Description:
 */
public class LeetCode_123 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 0){
            return 0;
        }
        int dp_i10 = 0;
        int dp_i20 = 0;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            dp_i10 = Math.max(dp_i10,dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, - prices[i]);
            dp_i20 = Math.max(dp_i20,dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21,dp_i10 - prices[i]);
        }
        return dp_i20;
    }


}
