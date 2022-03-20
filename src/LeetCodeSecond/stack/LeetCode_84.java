package LeetCodeSecond.stack;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/7/5 21:52
 * @Description:
 */
public class LeetCode_84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int len = heights.length;
        for (int i = 0; i < len ; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                Integer curHeight = stack.pop();
                while (!stack.isEmpty() && heights[curHeight] == heights[stack.peek()]){
                     stack.pop();
                }
                int cruWidth;
                if (stack.isEmpty()){
                    // i - 0 + 1 - 1
                    cruWidth = i;
                }else {
                    // 重要当前矩形高度围成的面积的宽度
                    // (i -  stack.peek()) + 1 - 2
                    cruWidth = i - stack.peek() - 1;
                }
                max = Math.max(max, cruWidth * heights[curHeight]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
           int curHeight =  stack.pop();
            while (!stack.isEmpty() && heights[curHeight] == heights[stack.peek()]){
                stack.pop();
            }
            int cruWidth;
            if (stack.isEmpty()){
                // i - 0 + 1 - 1
                cruWidth = len;
            }else {
                cruWidth = len - stack.peek() - 1;
            }
            max = Math.max(max, cruWidth * heights[curHeight]);
        }

        return max;
    }
    // 哨兵 + 单调栈
    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int len = heights.length;
        int[] newheights = new int[len + 2];
        System.arraycopy(heights,0,newheights,1,len);
        heights = newheights;
        for (int i = 0; i < len ; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                Integer curHeight = stack.pop();
                while (!stack.isEmpty() && heights[curHeight] == heights[stack.peek()]){
                    stack.pop();
                }
                int cruWidth = i - stack.peek() - 1;
                max = Math.max(max, cruWidth * heights[curHeight]);
            }
            stack.push(i);
        }
        return max;
    }
}
