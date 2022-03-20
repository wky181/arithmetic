package LeetCodeSecond.binarysearch;

/**
 * @Author: wky233
 * @Date: 2020/7/10 21:51
 * @Description: 二分法
 */
public class LeetCode_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int x = 0;
        int y = matrix[0].length-1;
        while (x < matrix.length && y >= 0){
            if (matrix[x][y] == target){
                return true;
            }else if (matrix[x][y] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
