package LeetCodeSecond.dp;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/23 22:39
 * @Description:
 */
public class LeetCode_674 {
    public int findLengthOfLCIS(int[] nums) {
        //dp[i] 表示以num[i]结尾的最长递增子序列
        int[] dp = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
