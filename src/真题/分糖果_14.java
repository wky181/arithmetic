package 真题;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/3/21 22:10
 * @Description:
 */
public class 分糖果_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count =0;
        while (true) {
            int t = arr[0];
            for (int i = 0; i <= n - 2; i++) {
                arr[i] = arr[i] / 2;
                arr[i] += arr[i + 1] / 2;
                if((arr[i]&1)==1){
                    count++;
                    arr[i]+=1;
                }
            }
            arr[n - 1] /= 2;
            arr[n - 1] += t / 2;
            if((arr[n-1]&1)==1){
                count++;
                arr[n-1]+=1;
            }
            if (check(arr)){
                System.out.println(count);
                break;
            }
        }
    }
    public static boolean check(int[] arr){
        int a = arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if (a!=arr[i]){
                 return false;
            }
        }
        return true;

    }

}
