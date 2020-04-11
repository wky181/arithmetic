package tensorts;

import bluebridgecup_course.class_03.Util;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/8 1:09
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        int[] sort = new InsertSort().sort1(randomArr);
        Util.print(sort);
    }
    public int[] sort(int[] nums) {
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < copyOf.length; i++) {
            int insert = i;
            for (int j = i - 1; j >= 0; j--) {
                if (copyOf[insert] < copyOf[j]){
                    int temp = copyOf[insert];
                    copyOf[insert] = copyOf[j];
                    copyOf[j] = temp;
                    insert = j;
                }
            }
        }
        return copyOf;
    }
    public int[] sort1(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < copy.length; i++) {
            int insert = copy[i];
            int j = i;
            while (j-1 >= 0 && insert < copy[j - 1]) {
                copy[j] = copy[j - 1];
                j--;
            }
            if (j != i) {
                copy[j] = insert;
            }

        }
        return copy;
    }


}
