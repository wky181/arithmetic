package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/4/5 14:28
 * @Description:
 */
public class LeetCode_84 {
    public static void main(String[] args) {

    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length ; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                Integer curIndex = stack.pop();
                int curHeight = heights[curIndex];
                while (!stack.isEmpty() && curHeight == heights[stack.peek()]){
                    stack.pop();
                }
                int kuan = 0;
                if (stack.isEmpty()){
                    kuan = i;
                }else {
                  //  kuan = i - 
                }
            }
            stack.add(i);
        }
        return 1;
    }
}
