package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/7 23:27
 * @Description:
 */
public class LeetCode_mian07 {
    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N - i -1 ; j++) {
                int temp = matrix[j][i];
                matrix[N-j-1][N-i-1] = matrix[i][j];
                matrix[N-i-1][j] = matrix[N-i-1][N-j-1];
                matrix[j][N-i-1] = temp;
             }
        }
    }
}
