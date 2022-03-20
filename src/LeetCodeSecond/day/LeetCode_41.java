package LeetCodeSecond.day;

/**
 * @Author: wky233
 * @Date: 2020/6/27 20:31
 * @Description:
 */
public class LeetCode_41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            // nums[nums[i]-1] != nums[i] 防止相等出现死循环
            while (nums[i] != i+1 && nums[i] <= nums.length && nums[i] > 0 &&  nums[nums[i]-1] != nums[i] ) {
                int temp =  nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
