package tensorts;

import bluebridgecup_course.class_03.Util;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/8 0:56
 * @Description: 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        int[] sort = new SelectionSort().sort(randomArr);
        Util.print(sort);
    }
    public int[] sort(int[] nums){
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length ; i++) {
            int min = i;
            for (int j = i+1; j < nums.length ; j++) {
                if (copyOf[j] < copyOf[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = copyOf[min];
                copyOf[min] =copyOf[i];
                copyOf[i] = temp;
            }
        }
        return copyOf;
    }
}
