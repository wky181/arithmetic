package class_09;

/**
 * @author 武凯焱
 * @date 2019/3/5 11:32
 * @Description:
 */
public class _9_2机器人走方格 {
    public static void main(String[] args) {
        System.out.println(solve(8,5));
        System.out.println(solve1(8,5));

    }
    public static int solve(int x ,int y){
        if (x == 1 || y == 1){
            return  1;
        }else {
            return solve(x-1,y)+solve(x,y-1);
        }
    }
    public static int solve1(int x , int y){
        if (x == 1 || y == 1){
            return  1;
        }
        int[][] arr = new int[x][y];
        for (int i = 0; i <y ; i++) {
            arr[0][i] = 1;
        }
        for (int i = 0; i <x ; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1; i <x ; i++) {
            for (int j = 1; j <y ; j++) {
                arr[i][j] = arr[i-1][j]+ arr[i][j-1];
            }
        }
        return arr[x-1][y-1];
    }
}
