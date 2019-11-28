package lanqiao;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/11/26 20:23
 * @Description: K好数
 */
public class ALGO_3 {
    public static void main(String[] args) {
        int MOD = 1000000007;
        Scanner scan = new Scanner(System.in);
        //k进制
        int k = scan.nextInt();
        //l位
        int l = scan.nextInt();
        //dps[m][n]为k好数的个数，m表示几位数，最大为l
        int dps[][] = new int[1100][1001];
        //任意相邻的两位不是相邻的数
        int sum  = 0;
        for (int i = 0; i < k; i++){
            dps[1][i] = 1;
        }
        for (int i = 2; i <=l ; i++) {
            for (int j = 0; j < k ; j++) {
                for (int m = 0; m < k ; m++) {
                    
                }
            }
            
        }

    }
}
