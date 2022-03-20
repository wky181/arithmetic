package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/30 20:14
 * @Description:
 */
public class LeetCode_57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if(nums[left] + nums[right] > target){
                right--;
            }else if (nums[left] + nums[right] < target){
                left++;
            }else {
                return new int[]{nums[left],nums[right]};
            }
        }
        return new int[]{-1,-1};
    }

}
