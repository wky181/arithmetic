package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/5/30 22:31
 * @Description:
 */
public class LeetCode_5480 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length){
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != target[i]){
                return false;
            }
        }
        return true;
    }
}
