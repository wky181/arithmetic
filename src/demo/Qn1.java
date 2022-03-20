package demo;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/23 20:18
 * @Description:
 */
public class Qn1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char[] s1 = new char[num];
        char[] s2 = new char[num];
        for (int i = 0; i < num ; i++) {
            s1[i] = sc.next().charAt(0);
        }
        for (int i = 0; i < num ; i++) {
            s2[i] = sc.next().charAt(0);
        }
        int[][] dp = new int[s1.length+1][s2.length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1[i-1] == s2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        System.out.println(dp[s1.length][s2.length]);
    }
}
