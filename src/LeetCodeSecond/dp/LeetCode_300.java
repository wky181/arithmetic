package LeetCodeSecond.dp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/2 10:31
 * @Description: LIS模板题
 */
public class LeetCode_300 {
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       Arrays.fill(dp, 1);
       int max = 1;
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
