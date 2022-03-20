package NewCoder.yuewen;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/5/19 19:56
 * @Description:
 */
public class test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sc = in.nextLine();
        String[] split = sc.split(",");
        int[] integers = new int[split.length];
        for (int i = 0; i < split.length ; i++) {
            integers[i] = Integer.parseInt(split[i]);
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < integers.length ; i++) {
            long ans = 1;
            for (int j = 0; j < integers.length; j++) {
                if (i != j){
                   ans *= integers[j];
                }
            }
            max = Math.max(ans,max);
        }
        for (int i = 0; i < integers.length ; i++) {
            long ans = 1;
            for (int j = 0; j < integers.length; j++) {
                if (i != j){
                    ans *= integers[j];
                }
            }
            if (ans == max){
                System.out.println(i);
                return;
            }
        }
    }
}
