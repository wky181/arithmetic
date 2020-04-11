package test;

import bluebridgecup_course.class_03.Util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/3/19 19:59
 * @Description:
 */
public class Coder01 {
    public static void main(String[] args) {
    /*    Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = in.nextInt();
        }*/
    int[] nums = Util.getRandomArr(10,1,9);
    Util.print(nums);
        Arrays.sort(nums);
        Util.print(nums);
        int start = nums[0];
        int end = nums[nums.length-1];
        int res = end - start;
        for (int i = 0; i < nums.length -1 ; i++) {
            int a = nums[i+1] - start;
            int b = end - nums[i];
            int max = Math.max(a, b);
            res = Math.min(max,res);
        }
        System.out.println(res);
    }
}
