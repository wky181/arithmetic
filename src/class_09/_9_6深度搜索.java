package class_09;

import java.util.Scanner;

/**
 * @author 武凯焱
 * @date 2019/3/9 15:09
 * @Description:
 */
/*
你一定听说过“数独”游戏。
如下图所示，玩家需要根据9×9盘面上的已知数字，推理出所有剩余空格的数字，并满足每一行、每一列、每一个同色九宫内的数字均含1-9，不重复。
数独的答案都是唯一的，所以，多个解也称为无解。
本图的数字据说是芬兰数学家花了3个月的时间设计出来的较难的题目。但对会使用计算机编程的你来说，恐怕易如反掌了。
本题的要求就是输入数独题目，程序输出数独的唯一解。我们保证所有已知数据的格式都是合法的，并且题目有唯一的解。
格式要求，输入9行，每行9个数字，0代表未知，其它数字为已知。
输出9行，每行9个数字表示数独的解。
输入：
0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0


程序应该输出：

145327698
839654127
672918543
496185372
218473956
753296481
367542819
984761235
521839764
*/
public class _9_6深度搜索 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] table = new int[9][9];
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        dfs(table,0,0);

    }
    public static void dfs(int[][] table,int x ,int y){
        if (x==9){
            print(table);
            System.exit(0);
        }
            if (table[x][y]==0){
                for (int i = 1; i <= 9 ; i++) {
                    boolean is = check(table,x,y,i);
                    if (is){
                        table[x][y] = i;
                        dfs(table, x + (y + 1) / 9,(y+1)%9);
                        table[x][y]=0;
                    }
                }

            }else {
                dfs(table, x + (y + 1) / 9,(y+1)%9);
            }
    }
    private static void print(int[][] table) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9 ; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean check(int[][] tables,int x , int y , int i){
        for (int j = 0; j <9 ; j++) {
            if (tables[x][j] == i ) return false;
            if (tables[j][y] == i)  return false;
        }
        for (int j = (x/3)*3; j < (x/3 +1)*3 ; j++) {
            for (int k = (y/3)*3; k <(y/3 +1)*3 ; k++) {
                if (tables[j][k] == i){
                    return false;
                }
            }
        }
        return true;
    }
}
