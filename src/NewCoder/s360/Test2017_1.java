package NewCoder.s360;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/3/24 15:08
 * @Description:
 */
public class Test2017_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n ; i++) {
            int size = scanner.nextInt();
            int[] nums = new int[size+1];
            //前i分金子的数量之和
            int[] sum = new int[size+1];
            for (int j = 1; j <= size ; j++) {
                nums[i] = scanner.nextInt();
                sum[j] = nums[i-1] + nums[i];
            }
            // 动态规划数组
            int[][] dp = new int[size+1][size+1];
            for (int j=1; j<=size; j++){
                dp[j][j] = nums[j];
                int k = 1;
                while (k <= n-1){
                    
                }
            }
            for (int j = 0; j < size ; j++) {
                nums[j] = scanner.nextInt();
            }
          solve(nums);
        }
    }

    public static void solve(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int rseA = 0;
        int resB = 0;
        boolean addA = true;
        while (left < right) {
            int max;
            int low;
            if (nums[left] > nums[right]) {
                max = nums[left];
                low = nums[right];
            } else {
                max = nums[right];
                low = nums[left];
            }
            if (addA) {
                rseA += max;
                resB += low;
            } else {
                rseA += low;
                resB += max;
            }
            addA = !addA;
            left++;
            right--;
        }
        System.out.println(rseA + " " + resB);
    }
}
