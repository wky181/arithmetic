package Interview;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/29 19:03
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] strings = s.split(",");
        int m = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n+1][m+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >=0 ; j--) {
                dp[i][j] = nums[i][j] + Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
