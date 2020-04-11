package tensorts;

import bluebridgecup_course.class_03.Util;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/8 0:33
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        int[] sort = new BubbleSort().sort(randomArr);
        Util.print(sort);
    }

    public int[] sort(int[] nums) {
        int[] arrays = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < arrays.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arrays.length - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    int temp = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arrays;
    }
}
