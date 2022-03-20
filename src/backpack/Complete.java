package backpack;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/1 21:00
 * @Description: 完全背包
 */
public class Complete {
    // 自底向上求完全背包问题 二维数组
    public static int dp2(int[] w, int[] v, int c) {
        int[][] dp = new int[w.length + 1][c + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 不选
                dp[i][j] = dp[i - 1][j];
                //  dp[i][j - w[i - 1]] 把历史的选择也带上
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        for (int i = 0; i < dp.length ; i++) {
            for (int j = 0; j < dp[i].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    // 自底向上求完全背包问题 一维数组
    public static int dp1(int[] w, int[] v, int c) {
        int[] dp = new int[c+1];
        for (int i = 0; i < w.length; i++) {
            // 01背包是倒着，要么不选，要么选一个 而完全背包是正者 可以选多个或者一个不选
            for (int j = w[i]; j < c ; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N ; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        System.out.println(dp1(w,v,V));
    }
}
