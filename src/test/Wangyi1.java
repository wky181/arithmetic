package test;

import leetcode.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/12 19:36
 * @Description:
 */
public class Wangyi1 {
    static long[][] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nums = new long[N][N];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        while (nums.length > 0){
            long[] longs = dfs();
            System.out.println(longs[0] + " "+ longs[1]);
        }
    }
    public static long[] dfs(){
        List<Integer> line = new ArrayList<>();
        List<Integer> clo = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            int resLine = 0;
            int resClo = 0;
            for (int j = 0; j < nums.length ; j++) {
                resLine += nums[i][j];
                resClo += nums[j][i];
            }
            line.add(resLine);
            clo.add(resClo);
        }
        int m = 0;
        int n = 0;
        long max = line.get(m) + clo.get(n);
        for (int i = 0; i < line.size(); i++) {
            for (int j = 0; j < clo.size(); j++) {
                long temp = line.get(i) + clo.get(j) - nums[i][j];
                if (temp > max){
                    m = i;
                    n = j;
                    max = temp;
                }
            }
        }
        long[][] temp = new long[line.size() - 1][clo.size() - 1];
        int index = 0;
        int cloIndex = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (i == m){
                continue;
            }
            for (int j = 0; j < nums.length ; j++) {
                if (j == n ){
                    continue;
                }
                temp[index][cloIndex++] = nums[i][j];
            }
            cloIndex = 0;
            index++;
        }
        nums = temp;
/*        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length ; j++) {
                System.out.print(nums[i][j] +" ");
            }
            System.out.println();

        }
        System.out.println("__________");*/
        return new long[]{m+1, n+1};
    }
}
