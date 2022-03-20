package demo;

/**
 * @Author: wky233
 * @Date: 2020/9/26 10:56
 * @Description:
 */
public class Sd2 {
    static int maxsumofSubarray(int[] arr) {
        if (arr == null || arr.length == 0){
            return 0;
        }
        int max = arr[0];
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (curSum < 0){
                curSum = arr[i];
            }else {
                curSum += arr[i];
            }
            max = Math.max(max, curSum);
        }
        return max;
    }
}
