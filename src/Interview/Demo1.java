package Interview;

import bluebridgecup_course.class_03.Util;
import leetcode.Utils;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/2/27 19:44
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = Utils.getRandomArr(7,1,10);
        Util.print(nums);
     /*   for (int i = 0; i < nums.length ; i++) {
            nums[i] = in.nextInt();
        }*/
        int count = 0;
        boolean isIncrement = true;
        for (int i = 1; i < nums.length ;) {
           if (isIncrement){
               if (nums[i] < nums[i-1]){
                   isIncrement = false;
                   continue;
               }
               while ( i < nums.length && nums[i-1] <= nums[i] ){
                   i++;
               }
               i++;
               count++;
           }else {
               if (nums[i-1] < nums[i]){
                   isIncrement = true;
                   continue;
               }
               while (i < nums.length && nums[i-1] >= nums[i] ){
                   i++;
               }
               i++;
               count++;
           }
        }
        System.out.println(count);
    }
}
