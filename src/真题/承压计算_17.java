package 真题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/3/19 19:43
 * @Description:
 */
public class 承压计算_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] arr = new double[30][30];
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <=i ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <arr.length ; i++) {
            arr[i][0] += arr[i-1][0]/2;
            arr[i][i] += arr[i-1][i-1]/2;
        }
        for (int i = 1; i <30 ; i++) {
            for (int j = 1; j < i ; j++) {
                arr[i][j] += arr[i-1][j-1]/2 + arr[i-1][j]/2;
            }
        }
        double[] arrs = new double[30];
        for (int i = 0; i <30 ; i++) {
            arrs[i] = arr[29][i];
        }
        Arrays.sort(arrs);
        double temp = 2086458231/arrs[0];
        System.out.println(arrs[29]*temp);
    }
}
