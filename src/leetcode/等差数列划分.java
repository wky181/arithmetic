package leetcode;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/3/9 22:28
 * @Description:
 */
public class 等差数列划分 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i <n ; i++) {
            A[i] = sc.nextInt();
        }
    }
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new  int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i-1] == A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
            }
        }
        int total = 0;
        for(int c : dp){
            total += c;
        }
        return total;
    }
}
