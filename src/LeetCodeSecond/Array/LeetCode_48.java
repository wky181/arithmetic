package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/7/4 15:04
 * @Description:
 */
public class LeetCode_48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int n = matrix.length;
        // 上下翻转
        for (int i = 0; i < n/2 ; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }
        /*//正对角线翻转 顺时针
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }*/
        //反对角线翻转 逆时针
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n - i ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }
    }
}
