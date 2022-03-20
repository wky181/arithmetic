package LeetCodeSecond.doublepointer;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/13 0:02
 * @Description:
 */
public class LeetCode_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length ; i++) {
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs( sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }
                if (sum > target){
                    right--;
                }
                else if (sum < target){
                    left++;
                }else {
                    return sum;
                }
            }
        }
        return ans;
    }
}
