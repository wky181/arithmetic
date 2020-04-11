package Interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/2/27 20:15
 * @Description:
 * 2
 * 5 2 8 5 1 5
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if (num <= 0){
            System.out.println(0);
            return;
        }
        long[] nums = new long[3 * num];
        for (int i = 0; i < 3 * num ; i++) {
            nums[i] = in.nextLong();
        }
        Arrays.sort(nums);
        long res = 0;
        int index = nums.length - 2;
       while (num -- > 0){
            res += nums[index];
            index -= 2;
       }
        System.out.println(res);
    }
}
