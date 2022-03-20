package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/4/4 23:29
 * @Description:
 */
public class LeetCode_42 {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(heights));
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
    public static  int trap1(int[] height) {
        int len = height.length;
        Deque<Integer> stack = new ArrayDeque();
        int ans = 0;
        for (int i = 0; i < len  ; i++) {
            // 找出以栈顶元素为最低点所形成的坑
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]){
                int curIndex = stack.pollLast();
                int topHeight = height[curIndex];
                while (!stack.isEmpty() && topHeight == height[stack.peekLast()]){
                    stack.pollLast();
                }
                if (!stack.isEmpty()) {
                    int curWedith = i - stack.peekLast() - 1;
                 //   System.out.println(stack.peekLast() + " " + topHeight);
                    int curheight = Math.min(height[i], height[stack.peekLast()]) - topHeight;
                 //   System.out.println(curheight + "*" + curWedith + "=" + curheight * curWedith + " i = " + i);
                    ans +=  curheight * curWedith;
                }
            }
            stack.addLast(i);
        }
        return ans;
    }
}
