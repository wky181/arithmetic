package Interview;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/29 19:25
 * @Description:
 */
public class T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(solve(num));

    }
    public static String solve(int num){
        if (num == 1 || num == 0){
            return "";
        }
        for (int i = 2; i < num / 2 + 1 ; i++) {
            if (num % i == 0){
                return i + "*" + solve(num / i);
            }
        }
        return num+"";
    }
}
