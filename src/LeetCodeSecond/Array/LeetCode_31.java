package LeetCodeSecond.Array;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/3 22:54
 * @Description:
 */
public class LeetCode_31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        for (int i = nums.length-1; i >= 1 ; i--) {
            if (nums[i] > nums[i-1]){
                int j = i;
                // 找到最靠后的一对逆序组
                while (nums[j] > nums[i-1]){
                    j++;
                    if (j ==  nums.length){
                        break;
                    }
                }
                j--;
                int temp = nums[j];
                nums[j] = nums[i-1];
                nums[i-1]  = temp;
                Arrays.sort(nums,i,nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
