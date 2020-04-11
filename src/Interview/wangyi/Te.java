package Interview.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/7 18:25
 * @Description:
 */
public class Te {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n - 1];
        long temp = sc.nextLong();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextLong() - temp;
            if (nums[i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        Arrays.sort(nums);
        long div = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] % nums[0] != 0) {
                long  num =  gcd(nums[i], div);
                if (num != 1){
                    div = num;
                }else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(div);
    }

    public static long gcd(long a, long b) {
        while (a % b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }
}
