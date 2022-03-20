package swordoffer;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/27 19:44
 * @Description:
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 2; i < 1000000000; i++) {
            if (jundge(i + "")){
                cnt++;
            }
            if (cnt == n){
                System.out.println(i);
            }
        }

    }
    public static boolean jundge(String str){
        for (int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if (c != '2' && c != '3' && c != '5'){
                return false;
            }
        }
        return true;
    }
}
