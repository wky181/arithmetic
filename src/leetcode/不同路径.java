package leetcode;

/**
 * @author 武凯焱
 * @date 2019/3/10 9:24
 * @Description:
 */
public class 不同路径 {
    public static void main(String[] args) {

    }
    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m ; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n ; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
