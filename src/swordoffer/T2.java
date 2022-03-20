package swordoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/27 20:05
 * @Description:
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            String line = sc.nextLine();
           // sc.nextLine();
            line.trim();
            String[] s = line.split(" ");
            for (String str: s) {
                if (str.length() == 0){
                    continue;
                }
                arrayList.add(Integer.parseInt(str));
            }
            listList.add(arrayList);
        }
        int m = listList.size();
        int nl = listList.get(m-1).size();
        int[][] dp = new int[m+1][nl+3];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < listList.get(i).size() ; j++) {
                dp[i][j] = listList.get(i).get(j);
            }
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = listList.get(i).size()-1; j >= 0; j--) {
                dp[i][j] += Math.max(Math.max(dp[i+1][j],dp[i+1][j+1]), dp[i+1][j+2]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
