package NewCoder.s360;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/3/22 0:56
 * @Description:
 */
public class Test2019_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long nums = 0;
        if (n < 3) {
            System.out.println(-1);
            return;
        }
        long maxPer  =  Long.MIN_VALUE;
        for (int i = 0; i < n ; i++) {
            long x = scanner.nextLong();
            maxPer = Math.max(x,maxPer);
            nums += x;
            if (i>=2 && maxPer < nums - maxPer ){
                System.out.println(i+1);
                break;

            }
        }
        System.out.println(-1);
    }
}
