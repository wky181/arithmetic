package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/4/2 14:45
 * @Description:
 */
public class LeetCode_435 {
    public static void main(String[] args) {

    }
    // LIS 动态规划
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <=1){
            return intervals.length;
        }
        Arrays.sort(intervals,(a,b) -> a[1]-b[1]);
        int[] memo = new int[intervals.length];
        Arrays.fill(memo,1);
        int res = 0;
        for (int i = 1; i < intervals.length ; i++) {
            for (int j = 0; j < i ; j++) {
                 if (intervals[i][0] >= intervals[j][1]){
                     memo[i] = Math.max(memo[i],memo[j] +1);
                 }
            }
            res = Math.max(res,memo[i]);
        }
        return intervals.length - res;
    }
    // 贪心
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length <=1){
            return 0;
        }
        Arrays.sort(intervals,(a,b) -> {
            if (a[1] != b[1]){
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        });
        int res = 1;
        // 从结尾最大的区间开始，只要start 大于等于下一个区间的end , 最大不重叠区间就+1
        int endVal = intervals[0][1];
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] >= endVal){
                res++;
                endVal = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
    // 贪心
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length <=1){
            return 0;
        }
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int res = 0;
        int endVal = intervals[0][1];
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] < endVal) {
                res++;
            }
        }
        return intervals.length - res;
    }
    // 贪心
    public int eraseOverlapIntervals3(int[][] intervals) {
            if (intervals.length <=1){
                return 0;
            }
            Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
            int res = 1;
            int x_end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                int start = intervals[i][0];
                if (start >= x_end){
                    res++;
                    x_end = intervals[i][1];
                }
            }
                return intervals.length - res;
        }
}
