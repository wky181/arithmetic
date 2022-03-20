package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/30 12:45
 * @Description:
 */
public class LeetCode_81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return true;
            }
            if (nums[mid] < nums[right]){
                if (target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                }else {
                    right = mid ;
                }
            }
            else if (nums[mid] > nums[right]){
                if (target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                //如果相等则不确定mid在左区间还是右区间，所以去掉干扰重复项
                // 因为我是nums[mid]和nums[right]相比所以right--
                right --;
            }
        }
        return false;
    }
}
