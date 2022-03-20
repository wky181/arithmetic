package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/28 21:03
 * @Description:
 */
public class LeetCode_122 {
    int res = 0;

    // 暴力搜索 超时
    public int maxProfit(int[] prices) {
        dfs(prices, 0, 0, 0);
        return res;
    }

    public void dfs(int[] prices, int i, int status, int profiles) {
        if (i == prices.length) {
            res = Math.max(res, profiles);
            return;
        }
        dfs(prices, i + 1, status, profiles);
        if (status == 0) {
            // 当前手里没股票，开始把当前买入
            dfs(prices, i + 1, 1, profiles - prices[i]);
        } else {
            // 卖出股票
            dfs(prices, i + 1, 0, profiles + prices[i]);
        }
    }

    // 贪心策略
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
    // 动态规划
    public int maxProfit2(int[] prices){
        // i表示当前能够获得的做大利益， j 0表示当前手里没股票，1表示当前手里有股票
        int beforeNobuy = 0;
        int beforyBuy = -prices[0];
        for (int i = 1; i < prices.length ; i++) {
            int tbeforeNobuy = beforeNobuy;
            beforeNobuy = Math.max(beforeNobuy, beforyBuy + prices[i]);
            beforyBuy = Math.max(beforyBuy, tbeforeNobuy - prices[i]);
        }
        return beforeNobuy;
    }
}
