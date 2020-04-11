package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/3/18 17:11
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        scanner.nextLine();
        String string = scanner.nextLine();
        String[] s = string.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(method(nums,target));
    }

    public static int method(int[] nums, int target) {
        if (nums == null){
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int num : nums) {
            target -= num;
            if (target < 0) {
               break;
            }
            res += num;
        }
        return res;
    }
}
