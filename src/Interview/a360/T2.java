package Interview.a360;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/24 11:34
 * @Description:
 */
public class T2 {
    static int res = 0;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m+1][n+1];
        for (int i = 1; i < m+1 ; i++) {
            for (int j = 1; j < n+1 ; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        dp = new int[m + 2][n + 1];
        dfs(0,n,m,0,nums);
        System.out.println(res);
    }
    public static void dfs(int k, int n, int m, int shanghai,int[][] nums){
        if (dp[k][n] != 0){
            return;
        }
        if (k == m+1 || n == 0){
            res = Math.max(shanghai,res);
            dp[k][n] = res;
            return;
        }
        for (int i = 0; i <= n ; i++) {
            dfs(k+1,n-i, m , shanghai + nums[k][i], nums);
        }
    }
}
