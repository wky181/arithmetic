package LeetCodeSecond.weekrank;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/5 10:30
 * @Description:
 */
public class LeetCode_5452 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int cha = arr[1] - arr[0];
        for (int i = 2; i < arr.length ; i++) {
            if (cha != (arr[i] - arr[i-1])){
                return false;
            }
        }
        return true;
    }
}
