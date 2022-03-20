package test;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/12 20:06
 * @Description:
 */
public class wangyi {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            if (helper()){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean helper() {

        String data = sc.nextLine();
      //  System.out.println(data + " sdd");
        String[] strings = data.split(" ");
        int[] T = new int[10];
        int[] B = new  int[10];
        int[] W = new int[10];
        for (int j = 0; j < strings.length; j++) {
            char c = strings[j].charAt(1);
            int num = strings[j].charAt(0) - '0';
            if (c == 'T') {
                T[num]++;
            }
            if (c == 'B'){
                B[num]++;
            }
            if (c == 'W'){
                W[num]++;
            }
        }
        int index = 0;
        for (int j = 0; j < T.length; j++) {
            if (T[j] > 1){
                return false;
            }
            if (T[j] == 1 ){
                if (index != 0 && j - index != 3){
                    return false;
                }
                index = j;
            }
        }
        index = 0;
        for (int j = 0; j < B.length ; j++) {
            if (B[j] > 1){
                return false;
            }
            if (B[j] == 1 ){
                if (index != 0 && j - index != 3){
                    return false;
                }
                index = j;
            }
        }
        index = 0;
        for (int j = 0; j < B.length ; j++) {
            if (W[j] > 1){
                return false;
            }
            if (W[j] == 1 ){
                if (index != 0 && j - index != 3){
                    return false;
                }
                index = j;
            }
        }
        return true;
    }
}
