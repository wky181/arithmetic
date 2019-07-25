package 蓝桥杯;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/3/15 20:37
 * @Description:
 */
public class Torry的困惑 {
    public static void main(String[] args) {
        long sum  = 1;
        int n ;
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        int i = 1;
        for (int num = 2; i <=n ; num++) {
            if (isPrime(num)){
                sum*=num;
                sum = sum%50000;
                i++;
            }

        }
        System.out.println(sum);
    }
    public static boolean isPrime(int n){
        if (n==2){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
