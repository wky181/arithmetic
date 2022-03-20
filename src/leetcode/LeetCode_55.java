package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/31 13:11
 * @Description:
 */
public class LeetCode_55 {
    public static void main(String[] args) {
        int a = 100;
        System.out.println(a---1);
    }
    public boolean canJump(int[] nums) {
            int maxLength = nums[0];
            for (int i = 0; i < nums.length-1 ; i++) {
                maxLength = Math.max(nums[i],maxLength-1);
                if (maxLength == 0){
                    return false;
                }
            }
            return true ;
    }
}
