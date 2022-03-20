package LeetCodeSecond.day;

import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/6/17 22:36
 * @Description:
 */
public class LeetCode_1014 {
    // 暴力超时
    public int maxScoreSightseeingPair(int[] A) {
        int ans = -1;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int num = A[j] + A[i] + j - i;
                ans = Math.max(ans,num);
            }
        }
        return ans;
    }
    //
    public int maxScoreSightseeingPair1(int[] A) {
        // 以 i为结尾的最大观光值
        int[] dp = new int[A.length];
        int max = -1;
        for (int i = 1; i < A.length ; i++) {
            int cur = A[i] - 1;
            dp[i] = A[i-1] + cur;
            dp[i] = Math.max(dp[i],dp[i-1] - A[i-1] + cur);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
