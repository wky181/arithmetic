package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/5/2 23:28
 * @Description:
 */
public class LeetCode_5387 {
    public static void main(String[] args) {
    }
    double l =  Math.pow(10,9)+7;
    int[][] dp;
    public int numberWays(List<List<Integer>> hats) {
        dp = new int[hats.size()+1][41];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        boolean[] visited = new boolean[41];
        int res = backTrance(0,hats,visited);
        return res;


    }
    public int  backTrance(int index,List<List<Integer>> hats, boolean[] visited){
        if (index == hats.size()){
            return 1;
        }
        int res = 0;
        List<Integer> list = hats.get(index);
        for (Integer integer: list) {
            if (!visited[integer]){
                visited[integer] = true;
                int temp =  (int) (backTrance(index+1,hats,visited) % l);
                dp[index][integer] = temp;
                res += temp;
                visited[integer] = false;
            }
        }
        return res;
    }
}
