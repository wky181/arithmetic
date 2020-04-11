package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/22 20:45
 * @Description:
 */
public class LeetCode_198 {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0, memo);
    }

    public int tryRob(int[] nums, int index, int[] memo) {
        if (index >= nums.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(nums[i], tryRob(nums, i + 2, memo));
        }
        memo[index] = index;
        return res;
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                dp[i] = Math.max(dp[i], (j - 2 < 0 ? 0 : dp[j - 2]) + nums[j]);
            }
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp_per_2 = 0;
        int dp_per_1 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = dp_per_1;
            dp_per_1 = Math.max(dp_per_1, dp_per_2 + nums[i]);
            dp_per_2 = temp;
        }
        return dp_per_1;
    }
}
