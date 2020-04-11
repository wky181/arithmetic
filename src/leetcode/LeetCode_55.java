package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/31 13:11
 * @Description:
 */
public class LeetCode_55 {
    public boolean canJump(int[] nums) {
        int maxpath = 0;
        for (int i = 0; i < nums.length ; i++) {
            maxpath = Math.max(nums[i] + i,maxpath);
        }
        return maxpath >= nums.length;
    }
}
