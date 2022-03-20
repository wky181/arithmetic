package LeetCodeSecond.offer2;

/**
 * @Author: wky233
 * @Date: 2020/8/20 22:08
 * @Description:
 */
public class offer_3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber(nums);
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }else {
                   int temp = nums[i];
                   nums[i] = nums[nums[i]];
                   nums[temp] = temp;
                }
            }
        }
        return nums.length-1;
    }
}
