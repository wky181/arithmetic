package NewCoder.zhaohang;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/8 19:32
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int number = sc.nextInt();
            int[] nums = toNums(str);
            res[i] = backTrace(nums,1,number - nums[0]);
        }
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static int[] toNums(String string) {
        char[] chars = string.toCharArray();
        int[] nums = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        return nums;
    }

    public static int backTrace(int[] nums, int index, int target) {
        if (target == 0 && index == nums.length) {
            return 1;
        }
        if (index >= nums.length){
            return 0;
        }
        return backTrace(nums,index+1,target - nums[index]) + backTrace(nums,index+1,nums[index] + target);
    }
}
