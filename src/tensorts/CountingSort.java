package tensorts;

import bluebridgecup_course.class_03.Util;
import leetcode.Utils;

/**
 * @Author: wky233
 * @Date: 2020/3/9 13:00
 * @Description:
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] randomArr = Utils.getRandomArr(10,1,60);
        Util.print(randomArr);
        new CountingSort().sort(randomArr);
        Util.print(randomArr);
    }

    public void sort(int[] nums) {
        int maxValue = getMaxValue(nums);
        int[] count = new int[maxValue + 1];
        for (int num : nums) {
            count[num]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                nums[index++] = i;
                count[i]--;
            }
        }

    }

    public int getMaxValue(int[] nums) {
        int value = nums[0];
        for (int num : nums) {
            value = Math.max(value, num);
        }
        return value;
    }
}
