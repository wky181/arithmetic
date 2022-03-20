package Interview.yuanfudao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/4/13 12:30
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int l = 0;
        int r = nums[0].length -1;
        int t = 0;
        int e = nums.length - 1;
        sc.close();
        System.out.println( t + " " +e);
        while (true){
            //先从上到下打印
            for (int i = t; i <= e ; i++) {
               list.add(nums[i][l]);
            }
            l++;
            if (l > r){
                break;
            }
            //在从左向右打印
            for (int i = l; i <= r ; i++) {
                list.add(nums[e][i]);
            }
            e--;
            if (e < t){
                break;
            }
            //在从下到上打印
            for (int i = e; i >= t ; i--) {
                list.add(nums[i][r]);
            }
            r--;
            if (r < l){
                break;
            }
            //从右到左打印
            for (int i = r; i >= l ; i--) {
                list.add(nums[t][i]);
            }
            t++;
            if (t > e){
                break;
            }

        }
        for (Integer integer: list) {
            System.out.print (integer +" ");
        }
    }
}
