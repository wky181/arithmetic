package Interview.wangyi;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/1/13 8:56
 * @Description: [编程题]最小数位和
 */
public class Test2020_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < n  ; i++) {
            solve(nums[i]);
        }

    }
    public static void solve(int n){
        if (n<=9){
            System.out.println(n);
            return;
        }
        int a = n%9;
        int b = n/9;
        StringBuilder sum = new StringBuilder();
        if (a!=0) {
            sum.append(a);
        }
        for (int i = 0; i < b; i++) {
            sum.append("9");
        }
        System.out.println(sum.toString());
    }
}
