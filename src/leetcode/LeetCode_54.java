package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/4/13 14:20
 * @Description:
 */
public class LeetCode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int r = matrix[0].length -1;
        int t = 0;
        int e = matrix.length - 1;
        System.out.println( t + " " +e);
        while (true){
            //从左向右打印
            for (int i = l; i <= r ; i++) {
                list.add(matrix[e][i]);
            }
            e--;
            if (e < t) {
                break;
            }
            //先从上到下打印
            for (int i = t; i <= e ; i++) {
                list.add(matrix[i][l]);
            }
            l++;
            if (l > r){
                break;
            }
            //从右到左打印
            for (int i = r; i >= l ; i--) {
                list.add(matrix[t][i]);
            }
            t++;
            if (t > e){
                break;
            }
            //从下到上打印
            for (int i = e; i >= t ; i--) {
                list.add(matrix[i][r]);
            }
            r--;
            if (r < l){
                break;
            }
        }
        return list;
    }
    public List<Integer> spiralOrder1(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[0].length-1;
        int end = matrix.length -1;
        List<Integer> res  = new ArrayList();
        while (true){
            if(left > right){
                break;
            }
            //从左到右
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top > end){
                break;
            }
            //从上到下
            for(int i = top; i <= end; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left > right){
                break;
            }
            //从右到左
            for(int i = right; i >= left; i--){
                res.add(matrix[end][i]);
            }
            end--;
            if(top > end){
                break;
            }
            //从下到上
            for(int i = end; i >= top; i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
