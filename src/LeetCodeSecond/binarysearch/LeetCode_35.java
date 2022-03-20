package LeetCodeSecond.binarysearch;

/**
 * @Author: wky233
 * @Date: 2020/7/17 23:01
 * @Description:
 */
public class LeetCode_35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums[0] >= target){
            return 0;
        }
        if (nums[nums.length-1] <= target){
            return nums.length ;
        }
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
