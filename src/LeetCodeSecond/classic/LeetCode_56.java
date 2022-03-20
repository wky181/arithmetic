package LeetCodeSecond.classic;


import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/9/10 9:38
 * @Description:
 */
public class LeetCode_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        Stack<int[]> lsit = new Stack<>();
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[1] != o2[1]){
                return o1[1] - o2[1];
            }else {
                return o1[0] - o2[1];
            }
        }));
        int len = intervals.length;
        int begin = intervals[len - 1][0];
        int end = intervals[len - 1][1];
        for (int i = len - 2; i >= 0; i--) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (begin <= r){
                begin = Math.min(l,begin);
            }else {
                lsit.add(new int[]{begin,end});
                begin = l;
                end = r;
            }
        }
        lsit.add(new int[]{begin,end});
        int[][] res = new int[lsit.size()][2];
        for (int i = 0 ; i <= res.length-1; i ++) {
            res[i] = lsit.pop();
         }
        return res;
    }
}
