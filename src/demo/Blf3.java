package demo;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/18 17:37
 * @Description:
 */
public class Blf3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        String str = sc.nextLine();
        String[] strings = str.split(",");
        int[] items = new int[strings.length];
        for (int i = 0; i <items.length ; i++) {
            if (strings[i].length() > 0) {
                items[i] = Integer.parseInt(strings[i]);
            }
        }
        int[] dp = new int[money+1];
        dp[0] = 1;
        for (int i = items[0]; i <= money ; i+= items[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < items.length ; i++) {
            for (int j = items[i]; j <= money ; j++) {
                dp[j] += dp[j - items[i]];
            }
        }
        System.out.println(dp[money]);
    }
}
