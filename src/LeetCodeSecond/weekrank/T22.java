package LeetCodeSecond.weekrank;

import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/14 20:53
 * @Description:
 */
public class T22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(getNum(nums));
    }
    static int[][] help = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
   static boolean[][] visit;
    public static int getNum(int[][] nums) {
        int res = 0;
        if (nums.length == 0){
            return 0;
        }
        visit = new boolean[nums.length][nums[0].length];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums[i].length ; j++) {
                if (nums[i][j] == 1 && !visit[i][j]){
                    res++;
                    dfs(nums,i,j);
                }
            }
        }
        return res;
    }
    public static boolean inAera(int[][] nums, int x, int y){
        if (x < 0 || x >= nums.length || y < 0 || y >= nums[x].length) {
            return false;
        }
        return true;
    }
    public static void dfs(int[][] nums, int x, int y){

        visit[x][y] = true;
        for (int i = 0; i < 4 ; i++) {
            int newX = x +help[i][0];
            int newY = y + help[i][1];
            if (inAera(nums,newX,newY) && !visit[newX][newY] && nums[newX][newY] == 1){
                dfs(nums,newX,newY);
            }
        }
    }
}
