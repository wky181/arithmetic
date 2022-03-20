package LeetCodeSecond.stack;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/7/5 20:36
 * @Description:
 */
public class LeetCode_85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] hegiht = new int[n];
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1'){
                    hegiht[j] += 1;
                }else {
                    hegiht[j] = 0;
                }
                while (!stack.isEmpty() && hegiht[j] < hegiht[stack.peek()]){
                    Integer curHeight = stack.pop();
                    while (!stack.isEmpty() && hegiht[stack.peek()] == hegiht[curHeight]){
                        stack.pop();
                    }
                    int width ;
                    if (stack.isEmpty()){
                        width = i;
                    }else {
                        width = i - stack.peek() - 1;
                    }
                    max = Math.max(max,hegiht[curHeight] * width);
                }
                stack.push(j);
            }
            while (!stack.isEmpty()){
                Integer curHeight = stack.pop();
                while (!stack.isEmpty() && hegiht[stack.peek()] == hegiht[curHeight]){
                    stack.pop();
                }
                int width ;
                if (stack.isEmpty()){
                    width = n;
                }else {
                    width = n - stack.peek() - 1;
                }
                max = Math.max(max,hegiht[curHeight] * width);
            }
        }
        return max;
    }





}
