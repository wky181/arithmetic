package leetcode.swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/5/17 10:19
 * @Description:
 */
public class LeetCode_39 {
   public int majorityElement(int[] nums) {
       int num = 0;
       int ans = nums[0];
       for (int i = 0; i <  nums.length; i++) {
           if (num == 0){
               ans = nums[i];
               num++;
           }
           else if (nums[i] == ans){
               num++;
           }else {
               num--;
           }
       }
       return ans;
    }
}
