package 真题;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/3/22 8:09
 * @Description:
 */
public class 地宫取宝_14 {
    static  long num;
    static int  k = 2;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
      //  int k = 2;
        int[][] martix = new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                martix[i][j] = sc.nextInt();
            }
        }
        sc.close();
        dfs(martix,0,0,-1,0);
        System.out.println(num);
    }
    public static void dfs(int[][] martix ,int i ,int j,int value,int count){
        if (i==martix.length-1 && j == martix[0].length-1){
                if (count==k){
                    num++;
                }
                else if (count-1==k && martix[i][j]>value){
                    num++;
                }
                return;
        }
        if (i==martix.length || j == martix[0].length ){
            return;
        }
        if (martix[i][j]>value){
            dfs(martix,i+1,j,martix[i][j],++count);
            dfs(martix,i,j+1,martix[i][j],++count);
        }
            dfs(martix,i+1,j,value,count);
            dfs(martix,i,j+1,value,count);
    }
}
