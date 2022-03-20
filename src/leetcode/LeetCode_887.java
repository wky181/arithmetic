package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/4/11 23:12
 * @Description:
 */
public class LeetCode_887 {
    int[][] memo;
    public int superEggDrop(int K, int N) {
        memo = new int[K+1][N+1];
        for (int i = 0; i < K+1 ; i++) {
            Arrays.fill(memo[i],-1);
        }
        int res = dp(K, N);
        return res;
    }

    public int dp(int K, int N){
        if (K == 1){
            return N;
        }
        if (N == 0){
            return 0;
        }
        if (memo[K][N] != -1){
            return memo[K][N];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= N ; i++) {
            res = Math.min(
                   res, Math.max(dp(K-1, i - 1) , dp(K, N-i))+1
            );
        }
        memo[K][N] = res;
        return res;
    }
}
