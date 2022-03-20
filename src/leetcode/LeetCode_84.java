package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/4/5 14:28
 * @Description:
 */
public class LeetCode_84 {
    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxRes = heights[0];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int curIndex = stack.pop();
                int hegiht = heights[curIndex];
                while (!stack.isEmpty() && hegiht == heights[stack.peek()]) {
                    stack.pop();
                }
                int curWidth;
                if (stack.isEmpty()) {
                    //当前0~i最小高度为hegiht，所以宽度为i
                    curWidth = i;
                } else {
                    //计算当前高度下标距离原来栈顶下标距离
                    curWidth = i - 1 - stack.peek() ;
                }
                int res = hegiht * curWidth;
             //   System.out.println(hegiht + "*" + curWidth +"=" + res);
                maxRes = Math.max(res, maxRes);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int lowIndex = stack.pop();
            int hegiht = heights[lowIndex];
            while (!stack.isEmpty() && hegiht == heights[stack.peek()]) {
                lowIndex = stack.pop();
            }
            int res;
            int curWidth;
            if (stack.empty()) {
                // heights最小高度为hegiht 宽度为heights.length
                curWidth = heights.length;
            } else {

                curWidth = heights.length -1 - stack.peek();
            }
            res = curWidth * hegiht;
         //   System.out.println(hegiht + "*" + curWidth +"=" + res);
            maxRes = Math.max(res, maxRes);
        }
        return maxRes;
    }
    // 利用哨兵机制
    public static int largestRectangleArea1(int[] heights) {
        // 左边和右边多一个高度为零的哨兵
        int[] newHeights  = new int[heights.length + 2];
        for (int i = 0; i < heights.length ; i++) {
            newHeights[i+1] = heights[i];
        }
        heights = newHeights;
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.addLast(0);
        int maxRes = -1;
        for (int i = 1; i < heights.length; i++) {
            while (heights[stack.peekLast()] > heights[i]){
                int curHeight = heights[stack.pollLast()];
                // 为什么要用i - stack.peekLast() - 1
                // 首先因为stack.peekLast()的下标对应的高度是curHeight左半部最右边小于当前高度的最大下标
                // i下标所对应的高度是curHeight右半部最左边小于当前高度的最小下标
                // 两者之间的距离为i - stack.peekLast()+1
                // 然后width = i - stack.peekLast()+1 - 2
                // i - stack.peekLast() - 1
                // 其实单调栈也就是利用了单调的性质记录了栈顶高度左部分小于栈顶高度的最大下标
                int curWidth = i - stack.peekLast() - 1;
                maxRes = Math.max(maxRes,curHeight * curWidth);

            }
            stack.addLast(heights[i]);
        }
        return maxRes;
    }
}
