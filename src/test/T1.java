package test;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/11 19:22
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            long N = sc.nextLong();
            long M = sc.nextLong();
            long min = Math.min(N, M);
            long res = N * M;
            if (res == 1){
                System.out.println(1);
            }else {
                for (int j = 2; j <= min; j++) {
                    if ((res % j) == 0 ){
                        System.out.println(j);
                    }
                }
            }
        }
    }
}
