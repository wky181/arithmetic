package LeetCodeSecond.dp;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/12 22:19
 * @Description: 倒推dp
 */
public class LeetCode_174 {
    public int calculateMinimumHP(int[][] dungeon) {
       int[][] dp = new int[dungeon.length + 1][dungeon[0].length + 1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i][dp[0].length - 1] = Integer.MAX_VALUE;
        }
        Arrays.fill(dp[dp.length-1],Integer.MAX_VALUE);
        dp[dungeon.length-1][dungeon[0].length] = 1;
        dp[dungeon.length][dungeon[0].length-1] = 1;
        for (int i = dungeon.length-1; i >= 0 ; i--) {
            for (int j = dungeon[0].length-1; j >= 0 ; j--) {
                    dp[i][j] = Math.max(1,Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}
