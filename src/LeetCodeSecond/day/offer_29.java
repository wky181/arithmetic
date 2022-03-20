package LeetCodeSecond.day;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/5 0:08
 * @Description:
 */
public class offer_29 {
    public int[] spiralOrder(int[][] matrix) {
         if(matrix.length == 0){
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
         int index = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int end = matrix.length-1;
        while(true){
            for(int i = left; i <= right; i++){
               res[index++] = matrix[top][i];
            }
            if(++top > end){
                break;
            }
            for(int i = top; i <= end ; i++){
               res[index++] = matrix[i][right];
            }
            if(left > --right){
                break;
            }
            for(int i = right; i >= left; i--){
               res[index++] = matrix[end][i];
            }
            if(top > --end){
                break;
            }
            for(int i = end; i >= top; i--){
               res[index++] = matrix[i][left];
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}
