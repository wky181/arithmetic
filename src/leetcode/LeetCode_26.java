package leetcode;

import bluebridgecup_course.class_03.Util;

/**
 * @author 武凯焱
 * @date 2019/12/7 16:06
 * @Description:
 */
public class LeetCode_26 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(removeDuplicates(nums));
        Util.print(nums);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int  flag = 0;
        int pre = nums[0];
        for (int i = 0; i < nums.length ; i++) {
           if (nums[i]  !=  pre){
                nums[flag] = pre;
                flag++;
                pre = nums[i];
            }
        }
        if (nums[nums.length-1] == pre){
                nums[flag] = pre;
        }
        return flag+1;
    }
}
