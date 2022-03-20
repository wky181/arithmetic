package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/30 14:39
 * @Description:
 */
public class LeetCode_69 {
    public static void main(String[] args) {
        System.out.println((2 + Integer.MAX_VALUE) >>> 1 );
    }
    public int mySqrt(int x) {
        long left = 0;
        long right  = x / 2 + 1;
        while (left < right){
            long mid = left + ((right - left + 1 ) >> 1);
            if (mid * mid > x){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return (int)left;
    }
    public int mySqrt1(int x) {
        long left = 0;
        long right = x / 2  + 1;
        while (left < right){
            long mid = (left + right) >>> 1;
            if (mid * mid > x){
                left = mid - 1;
            }else {
                right = mid;
            }
        }
        return (int) left;
    }
}
