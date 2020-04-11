package Interview.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/3 23:49
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count  = sc.nextInt();
        int[] nums = new int[count];
        int two = 0;
        int one = 0;
        for (int i = 0; i < count ; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] % 2 == 0){
                two++;
            }else {
                one++;
            }
        }
        if (two == nums.length || one == nums.length){
            for (int num: nums) {
                System.out.print(num+" ");
            }
        }else {
            Arrays.sort(nums);
            for (int num: nums) {
                System.out.print(num+" ");
            }
        }
    }
}