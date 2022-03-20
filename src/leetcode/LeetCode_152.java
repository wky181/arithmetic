package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/18 21:00
 * @Description:
 */
public class LeetCode_152 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] >= 0){
                dp[i][0] = Math.min(nums[i],dp[i-1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i-1][1] * nums[i]);
            }else {
                dp[i][0] = Math.min(nums[i],dp[i-1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i-1][0] * nums[i]);
            }
        }
        int ans = dp[0][1];
        for (int i = 0; i < nums.length ; i++) {
            ans = Math.max(dp[i][1],ans);
        }
        return ans;
    }

    /**
     * 压缩空间
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {

        int perMin = nums[0];
        int perMax = nums[0];
        int ans = perMax;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] >= 0){
                perMin = Math.min(nums[i],perMin * nums[i]);
                perMax = Math.max(nums[i], perMax * nums[i]);
            }else {

                int tmpMin = Math.min(nums[i], perMax * nums[i]);
                perMax = Math.max(nums[i], perMin * nums[i]);
                perMin = tmpMin;
            }
            ans = Math.max(perMax,ans);

        }
        return ans;
    }
}
