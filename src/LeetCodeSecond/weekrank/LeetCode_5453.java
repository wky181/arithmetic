package LeetCodeSecond.weekrank;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/5 10:42
 * @Description:
 */
public class LeetCode_5453 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int minLeft = n;
        int maxRight = -1;
        for (int i = 0; i < right.length ; i++) {
            minLeft = Math.min(right[i],minLeft);
        }
        for (int i = 0; i < left.length ; i++) {
            maxRight = Math.max(left[i],maxRight);
        }
        minLeft = n - minLeft - 1;
        maxRight = Math.max(n,maxRight);
        return Math.max(minLeft,maxRight);
    }
}
