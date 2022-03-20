package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/9/20 20:41
 * @Description:
 */
public class Dxm1 {
    static int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int num = Integer.MAX_VALUE;
    static boolean[][] visited;
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[][] strings = new String[n][m];
            visited = new boolean[n][m];
            int x = 0;
            int y = 0;
            for (int j = 0; j < n ; j++) {
                String s = sc.next();
              //  System.out.println(s);
                for (int k = 0; k < m; k++) {
                    strings[j][k] = s.charAt(k)+"";
                    if (strings[j][k].equals("@")){
                        x = j;
                        y = k;
                    }
                }
            }
            dfs(strings,x,y,0);
            num = Integer.MAX_VALUE == num ? -1 : num;
            res.add(num);
            num = Integer.MAX_VALUE;
        }
        for (int c: res) {
            System.out.println(c);
        }
    }
    public static void dfs(String[][] strings, int x, int y, int count){
        if ( x == 0 || x == strings.length-1 || y == 0 || y == strings[x].length-1){
            num = Math.min(num,count);
        }
        for (int i = 0; i < 4  ; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
         //   System.out.println(strings[newX][newY]);
            if (jundge(strings,newX,newY) && !strings[newX][newY] .equals("#") && !visited[newX][newY]) {
                visited[newX][newY] = true;
                if (strings[newX][newY].equals("*")) {
                    dfs(strings, newX, newY, count+1);
                } else {
                    dfs(strings, newX, newY, count);
                }
                visited[newX][newY] = false;
            }
        }

    }
    public static boolean jundge(String[][] strings, int x, int y){
        if (x < 0 || x >= strings.length || y < 0 || y >= strings[0].length){
            return false;
        }
        return true;
    }
}
