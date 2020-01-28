package leetcode;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/1/21 21:55
 * @Description:
 */
public class LeetCode_80 {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new LeetCode_80().removeDuplicates(nums));
        Util.print(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //0~k是最终的结果区间，当有新数字出现，或者第二次出现时，k指针移动一位
        int k = 0;
        //记录当前数字出现次数
        int sums = 0;
        for (int i = 0; i < nums.length; i++) {
            //出现了新的数字，k指针往后移动
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
                sums = 1;
            } else {
                sums++;
                //第二次出现的数字，加入到前面的结果区间后面
                if (sums == 2) {
                    nums[++k] = nums[i];
                }
            }
        }
        return k + 1;
    }
}
