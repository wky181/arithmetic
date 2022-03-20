package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/26 14:45
 * @Description:
 */
public class LeetCode_44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count){
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * start * digit;
        }
        // 此时n代表digit位的第几位数字从1开始的
        // 求所在数位的数字具体为多少
        long num = start + (n-1) / digit;
        return Long.toString(num).charAt((n-1) % digit) - '0';

    }
}