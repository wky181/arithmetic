package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/24 22:38
 * @Description: 01背包问题
 */
public class Example_01 {
    public static void main(String[] args) {
        int[] w = {2, 2, 6, 5, 4};
        int[] v = {6, 3, 5, 4, 6};
        int captiy = 10;
        int[][] memo = new int[w.length][captiy + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(slove(w, v, w.length - 1, 10, memo));
        System.out.println(dp2(w, v, captiy));
    }

    //自顶向下求01背包问题
    public static int slove(int[] w, int[] v, int index, int c, int[][] memo) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = slove(w, v, index - 1, c, memo);
        if (c - w[index] >= 0) {
            res = Math.max(res, v[index] + slove(w, v, index - 1, c - w[index], memo));
        }
        //  System.out.println(index + " "+ c);
        memo[index][c] = res;
        return res;
    }

    // 自底向上求01背包问题
    public static int dp(int[] w, int[] v, int c) {
        if (w.length == 0 || v.length == 0) {
            return 0;
        }
        int[][] memo = new int[w.length][c + 1];
        for (int i = 1; i <= c; i++) {
            if (i - w[0] >= 0) {
                memo[0][i] = v[0];
            }
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= c; j++) {
                if(j - w[i] >= 0) {
                    memo[i][j] = Math.max(memo[i - 1][j], v[i] + memo[i - 1][Math.max(j - w[i], 0)]);
                }else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[w.length - 1][c];
    }

    // 自底向上求01背包问题 优化空间复杂度O(n*c) -> O(c)
    public static int dp1(int[] w, int[] v, int c) {
        if (w.length == 0 || v.length == 0) {
            return 0;
        }
        int[][] memo = new int[2][c + 1];
        for (int i = 1; i <= c; i++) {
            if (i - w[0] >= 0) {
                memo[0][i] = v[0];
            }
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= c; j++) {
                if(j - w[i] >= 0) {
                    memo[i % 2][j] = Math.max(memo[(i - 1) % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }else {
                    memo[i % 2][j] = memo[(i - 1) % 2][j];
                }
            }
        }
        return memo[(w.length - 1) % 2][c];
    }

    // 自底向上求01背包问题 优化空间复杂度O(n*c) -> 一维数组
    public static int dp2(int[] w, int[] v, int c) {
        if (w.length == 0 || v.length == 0) {
            return 0;
        }
        int[] memo = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            if (i - w[0] >= 0) {
                memo[i] = v[0];
            }
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = c; j >=  w[i]; j--) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[c];
    }
}
