package LeetCodeSecond.weekrank;

/**
 * @Author: wky233
 * @Date: 2020/7/5 10:35
 * @Description:
 */
public class LeetCode_5454 {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] widths = new int[m][n];
        int count = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1){
                    widths[i][j] = j == 0 ? 1 : widths[i][j-1] + 1;
                    int minWidth = widths[i][j];
                    for (int k = i; k >= 0 ; k--) {
                        minWidth = Math.min(minWidth,widths[k][j]);
                        int width = minWidth;
                        while (width > 0){
                            count++;
                            width--;
                        }
                        if (minWidth == 0){
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }
}
