package test;

import java.util.Arrays;

import static test.Test01.method;

/**
 * @Author: wky233
 * @Date: 2020/9/14 20:42
 * @Description:
 */
public class T133 {
    public int firstMissingPositive (int[] nums) {
        // write code here
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            int res = method(nums, i);
            if (res == -1){
                return i;
            }
        }
        return nums.length + 1;
    }

    private int method(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }
}
