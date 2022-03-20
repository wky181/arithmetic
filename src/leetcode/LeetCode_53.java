package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/18 22:13
 * @Description:
 */
public class LeetCode_53 {
    //贪心
    public int maxSubArray(int[] nums) {
        int ans = 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(ans < 0){
                ans = nums[i];
            }else{
                ans += nums[i];

            }
            max = Math.max(max, ans);
        }
        return max;
    }
    // 动态规划
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i-1] > 0 ){
                nums[i] += nums[i-1];
            }
            max = Math.max(max,nums[i]);
        }
        return max;
    }

}
