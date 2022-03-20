package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2021/3/31 21:30
 * @Description:
 */
public class Baidu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int p1 = 100 - p;
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2*n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j){

                }
            }

        }
    }
}
