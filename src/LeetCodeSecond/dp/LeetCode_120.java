package LeetCodeSecond.dp;

import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/7/14 23:18
 * @Description:
 */
public class LeetCode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        int n = dp.length+1;
        int number = -1;
        for (int i = triangle.size()-1; i >= 0 ; i--) {
            number++;
            for (int j = 0; j < n - 1 - number ; j++) {
                dp[j] = triangle.get(i).get(j) +  Math.min(dp[j],dp[j]+1);
            }
        }
        return dp[0];
    }
}
