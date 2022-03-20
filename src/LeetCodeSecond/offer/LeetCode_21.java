package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/18 17:57
 * @Description:
 */
public class LeetCode_21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            while (left < right && (nums[left] & 1) == 1 ){
                left++;
            }
            while (left < right && (nums[right] & 1) == 0 ){
                right--;
            }
            if (left < right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
        }
        return nums;
    }
}
