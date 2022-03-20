package LeetCodeSecond.hash;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/24 22:52
 * @Description:
 */
public class LeetCode_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int cha = Math.abs(res - target);
        for (int i = 0; i < nums.length ; i++) {
            // 利用双指针找到在nums[i] 确定下的最接近的三数之和
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int sums = nums[i] + nums[left] + nums[right];
                int sumsCha = Math.abs(sums - target);
                if (cha > sumsCha){
                    res = sums;
                    cha = sumsCha;
                }
                if (sums > target){
                    right--;
                }else if (sums < target){
                    left++;
                }else {
                    return sums;
                }
            }
        }
        return res;
    }
}
