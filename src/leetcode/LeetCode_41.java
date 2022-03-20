package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/7 15:36
 * @Description:
 */
public class LeetCode_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            while (nums[i] >= 1 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]){
                swap(i,nums[i] - 1,nums);
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            // 找到第一个不匹配的数字下标
            if (nums[i] != i+1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
