package leetcode;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/5/6 10:33
 * @Description:
 */
public class LeetCode_983 {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = -1;
        HashSet<Integer> hashSet = new HashSet<>(days.length);
        for (int day :days) {
            hashSet.add(day);
            maxDay = Math.max(day, maxDay);
        }
        //找出最大天数，然后+1 dp[i] 表示第i天所花费最小值
        int[] dp = new int[maxDay+1];
        for (int i = 1; i <= maxDay ; i++) {
            // 如果第i天不需要旅行，那么状态转移方程为dp[i] = dp[i-1];
            if (hashSet.contains(i)){
                dp[i] = dp[i-1];
            }else {
                // 如果第i天必须旅行,则找出最小花费
                dp[i] = minCost(dp[Math.max(i - 1, 0)] + costs[0],
                        dp[Math.max(i-7, 0) ] +costs[1],
                           dp[Math.max(i - 30, 0)] + costs[2]);
            }
        }
        return dp[maxDay];
    }
    public int minCost(int a, int b, int c){
        int min = Math.min(a,b);
        return Math.min(min, c);
    }
}
