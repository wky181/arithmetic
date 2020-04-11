package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/22 23:28
 * @Description:
 */
public class LeetCode_213 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length < 2){
            return nums[0];
        }
       return Math.max(rangeRob(nums,0,nums.length-2),rangeRob(nums,1,nums.length-1));
    }
    public int rangeRob(int[] nums, int start,int end) {
        int dp_per_2 = 0;
        int dp_per_1 = 0;
        for (int i = end; i >= start ; i--) {
            int temp = dp_per_1;
            dp_per_1 = Math.max(dp_per_1,dp_per_2 + nums[i]);
            dp_per_2 = temp;
        }
        return dp_per_1;
    }
}
