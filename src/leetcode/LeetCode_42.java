package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/4/4 23:29
 * @Description:
 */
public class LeetCode_42 {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 当前高度比栈顶高度高，肯定有坑，与栈顶的下一个元素形成的坑
                int curIndex = stack.pop();
                while (!stack.isEmpty() && height[curIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()){
                   int topIndex =  stack.peek();
                   int heigh = Math.min(height[i],height[topIndex]) - height[curIndex];
                   int kuan = i - topIndex - 1;
                   ans += heigh * kuan;
                }
            }
            stack.add(i);
        }
        return ans;
    }
}
