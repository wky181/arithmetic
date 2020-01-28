package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/1/21 15:28
 * @Description: 移动零
 */
public class LeetCode_283 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new LeetCode_283().moveZeroes1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }

    /**
     * 时间空间复杂度都为O(n)
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        for (int i = list.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 时间复杂度O(n),空间复杂度O(1) 让[0,p)区间的元素为非零
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 再次优化，让非零数字与零直接交换，省去置零操作
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != p) {
                    swap(i, p, nums);
                }
                p++;
            }
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
