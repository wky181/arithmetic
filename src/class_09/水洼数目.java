package class_09;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/4/10 21:36
 * @Description:
 */
public class 水洼数目 {
    /*
有一个大小为 N*M 的园子，雨后积起了水。八连通的积水被认为是连接在一起的。请求出
园子里总共有多少水洼？（八连通指的是下图中相对 W 的*的部分）

    ***
    *W*
    ***

限制条件

 N, M ≤ 100

 样例:

 输入
    N=10, M=12

园子如下图（'W'表示积水， '.'表示没有积水）

W........WW.
.WWW.....WWW
....WW...WW.
.........WW.
.........W..
..W......W..
.W.W.....WW.
W.W.W.....W.
.W.W......W.
..W.......W.

输出

    3

 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        char[][] a = new char[n][];
        for (int i = 0; i <n ; i++) {
                a[i] = sc.next().toCharArray();
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if (a[i][j]=='W'){
                    dfs(i,j,a); //清除一个水坑
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(int i ,int j,char[][] a ){
        a[i][j] = '.';
        for (int k = -1; k <2 ; k++) {
            for (int l = -1; l <2 ; l++) {
                if (k==0 && l==0){
                    continue;
                }
                if (i+k>=0&&i+k<a.length && j+l>=0 && j+l<a[0].length){
                    if (a[i+k][j+l]=='W'){
                        dfs(i+k,j+l,a);
                    }
                }
            }
        }
    }
}
