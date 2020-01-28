package leetcode;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/1/22 16:20
 * @Description: 计数排序 三路快排
 */
public class LeetCode_72 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new LeetCode_72().sortColors1(nums);
        Util.print(nums);
    }
    /**
     * 计数排序 时间空间复杂度都为O(n)
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null){
            return;
        }
        int[] numbers = new int[3];
        for (int i = 0; i < nums.length ; i++) {
            numbers[nums[i]]++;
        }
        int bigen = 0;
        int end = 0;
        for (int i = 0; i < numbers.length ; i++) {
            bigen = end;
            end += numbers[i];
            method(nums,bigen,end,i);
        }
    }
    public void method(int[] nums,int bigen,int end,int value) {
        for (int i = bigen; i < end ; i++) {
            nums[i] = value;
        }
    }

    /**
     * 三路快排
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two ;) {
            if (nums[i] != 1){
                if (nums[i] > 1 ){
                    swap(i,--two,nums);
                }else {
                    swap(i,++zero,nums);
                    i++;
                }
            }else {
                i++;
            }
        }
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
