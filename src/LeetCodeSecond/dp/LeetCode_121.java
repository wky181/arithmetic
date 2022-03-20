package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/28 20:33
 * @Description: 股票系列问题
 */
public class LeetCode_121 {
    int max = 0;
    // 暴力解
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        for (int i = 0; i < prices.length ; i++) {
            for (int j = i + 1; j < prices.length ; j++) {
                max = Math.max(max,prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 0; i < prices.length ; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
