package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/4/17 14:12
 * @Description:
 */
public class LeetCode_452 {
    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;
        int x_end = points[0][1];
        for (int i = 1; i < points.length ; i++) {
            int start = points[i][0];
            if (start > x_end){
                x_end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
