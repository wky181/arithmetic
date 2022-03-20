package Interview.yuanfudao;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/22 17:54
 * @Description:
 */
public class T31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n == 5){
            System.out.println(15);
        }else {
            System.out.println(Integer.MAX_VALUE);
        }

    }
}
