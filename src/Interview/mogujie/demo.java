package Interview.mogujie;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/19 23:09
 * @Description:
 */
public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int X = x + 1;
        int Y = y + 1;
        int[][] dp = new int[X][Y];
        for (int i = 0; i < Y; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < X; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < X; i++) {
            for (int j = 1; j < Y; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[X - 1][Y - 1]);
    }
}
