package LeetCodeSecond.binarysearch;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/14 22:18
 * @Description:
 */
public class LeetCode_1300 {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr[arr.length-1];
        while (left < right){
            int mid = left + (right - left) / 2;
            int sum = getSum(mid, arr);
            // 找到下边界
            if (sum > target){
                right  = mid-1;
            }else {
                left = mid;
            }
        }
        int top = left + 1;
        int tops = getSum(top,arr);
        int ends = getSum(left,arr);
        if (Math.abs(tops - target) < Math.abs(ends - target)){
            return top;
        }else {
            return left;
        }
    }
    private int getSum(int value, int[] nums){
        int i = 0;
        int sum = 0;
        for (;i < nums.length ; i++) {
            if ( nums[i] >= value){
                break;
            }else {
                sum += nums[i];
            }
        }
        sum += (nums.length - i) * value;
        return sum;
    }
}
