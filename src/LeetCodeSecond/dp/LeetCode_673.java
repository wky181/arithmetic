package LeetCodeSecond.dp;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/23 23:07
 * @Description:
 */
public class LeetCode_673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j]+1){
                        count[i] += count[j];
                    }else if (dp[i] < dp[j]+1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            max = Math.max(dp[i],max);
            System.out.println(max);
        }
        int res = 0;
        for (int i = 0; i < dp.length ; i++) {
            if (dp[i] == max){
                res += count[i];
            }
        }
        return res;
    }
}
