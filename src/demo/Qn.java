package demo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/23 19:53
 * @Description:
 */
public class Qn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        BigDecimal bigDecimal = new BigDecimal(1);
        for (int i = m; i > m - n ; i--) {
            bigDecimal = bigDecimal.multiply(new BigDecimal(i));
        }
        for (int i = 2; i <= n; i++) {
            bigDecimal = bigDecimal.divide(new BigDecimal(i));
        }
        System.out.println(bigDecimal);
    }

}
