package LeetCodeSecond.offer2;

/**
 * @Author: wky233
 * @Date: 2020/8/22 15:27
 * @Description:
 */
public class offer_4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0){
            if (matrix[m][n] == target){
                return true;
            }else if (matrix[m][n] < target){
                m++;
            }else {
                n--;
            }
        }
        return false;
    }
}
