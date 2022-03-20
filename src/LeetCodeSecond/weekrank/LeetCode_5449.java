package LeetCodeSecond.weekrank;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/28 10:39
 * @Description:
 */
public class LeetCode_5449 {
    public boolean canArrange(int[] arr, int k) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        while (i < j){
            if ((arr[i] + arr[j]) % k != 0){
                return false;
            }
            i++;
            j--;
        }
        return false;
    }
}
