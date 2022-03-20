/*
package Interview.ByteDance;

import java.util.Scanner;

*/
/**
 * @Author: wky233
 * @Date: 2020/8/25 20:08
 * @Description:
 *//*

public class T1 {
    public static int method(int k, int[] v, int[] values){
        int[][] memo = new int[v.length + 1][k + 1];
        for (int i = 1; i < memo.length ; i++) {
            Scanner
            for (int j = 0; j < memo[0].length; j++) {
                if (v[i - 1] > j){

                    memo[i][j] = memo[i-1][j];
                }else {

                    memo[i][j]  = Math.max(memo[i-1][j], memo[i-1][j - v[i-1]] + values[i-1]);

                }
            }
        }
        return memo[memo.length-1][memo[0].length-1];
    }
}
*/
