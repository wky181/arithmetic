package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/7/4 20:42
 * @Description:
 */
public class LeetCode_85 {
    public int maximalRectangle(char[][] matrix) {
        // 记录每行的连续1的个数
        int[][] widths = new int[matrix.length][matrix[0].length];
        int m = widths.length;
        int n = widths[0].length;
        int s = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (matrix[i][j] == '1'){
                    widths[i][j] = j == 0 ? 1 : widths[i][j-1] + 1;
                }
                int width = widths[i][j];
                for (int k = i; k >=0 ; k--) {
                    width = Math.min(width,widths[k][j]);
                    s = Math.max(s,width * (i - k + 1));
                }
            }
        }
        return s;
    }
}
