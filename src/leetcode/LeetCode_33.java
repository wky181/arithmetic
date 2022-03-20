package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/29 23:59
 * @Description:
 */
public class LeetCode_33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            // 定到右中位数
            int mid = left + (right - left + 1) / 2;
            if (target == nums[mid]){
                return mid;
            }
            // 右区间有序
            if (nums[mid] <= nums[right]){
                // 先考虑容易情况
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if (nums[mid] > target && target >= nums[left]){
                    right = mid -1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
