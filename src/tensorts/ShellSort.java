package tensorts;

import bluebridgecup_course.class_03.Util;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/8 13:04
 * @Description:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        int[] sort = new ShellSort().sort(randomArr);
        Util.print(sort);
    }

    public int[] sort(int[] nums) {
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        int gap = 1;
        while (gap < nums.length) {
            gap = gap * 2 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < copyOf.length; i++) {
                int insert = nums[i];
                int j = i;
                while (j-gap >= 0 && insert < copyOf[j - gap]) {
                    copyOf[j] = copyOf[j - gap];
                    j -= gap;
                }
                    copyOf[j] = insert;
            }
            gap = gap / 2;
        }
        return copyOf;
    }
}
