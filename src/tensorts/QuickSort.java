package tensorts;

import bluebridgecup_course.class_03.Util;
import leetcode.Utils;

/**
 * @Author: wky233
 * @Date: 2020/3/8 20:19
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] randomArr = Utils.getRandomArr(10, 1, 60);
        Util.print(randomArr);
        new QuickSort().sort(randomArr, 0, randomArr.length - 1);
        Util.print(randomArr);
    }

    public void sort(int[] nums, int l, int r) {
        if (l < r) {
            int partition = partition(nums, l, r);
            sort(nums, l, partition - 1);
            sort(nums, partition + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int p = nums[l];
        //Mark初始化为起始下标,mark代表左边序列的最右边
        int mark = l;
        for (int i = l+1; i <= r ; i++) {
            if (nums[i] < p){
                mark++;
                swap(nums,i,mark);
            }
        }
        nums[l] = nums[mark];
        nums[mark] = p;
        return mark;

    }

    public void swap(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        nums[l] = nums[l] ^ nums[r];
        nums[r] = nums[r] ^ nums[l];
        nums[l] = nums[r] ^ nums[l];
    }
}
