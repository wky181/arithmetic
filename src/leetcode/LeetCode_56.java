package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/4/16 22:51
 * @Description:
 */
public class LeetCode_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2){
            return intervals;
        }
        Arrays.sort(intervals, ((o1, o2) -> o1[0] - o2[0]));
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] before = list.get(list.size() - 1);
            if (intervals[i][0] <= before[1]){
                before[1] = Math.max(intervals[i][1],before[1]);
            }else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
