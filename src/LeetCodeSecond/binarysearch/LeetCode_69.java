package LeetCodeSecond.binarysearch;

/**
 * @Author: wky233
 * @Date: 2020/9/16 23:17
 * @Description:
 */
public class LeetCode_69 {
    public int mySqrt(int x) {
        long left = 0;
        long right = x / 2 + 1;
        while (left < right){
            long mid = (right - left + 1) / 2 + left;
            long res = mid * mid;
            if (res > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int) left;
    }
}
