package LeetCodeSecond.stack;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/7/4 9:50
 * @Description:
 */
public class LeetCode_32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        int max = 0;
        // 初始化
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else {
                // 先弹出 然后看是匹配的左括号弹出了，还是断点弹出了
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }

    // dp解法
    public int longestValidParentheses1(String s) {
        //dp[i]表示以i结尾的最大括号长度
        int max = 0;
        int[] dp = new int[s.length()];
        char[] array = s.toCharArray();
        for (int i = 1; i < dp.length; i++) {
            if (array[i] == ')') {
                if (array[i - 1] == '('){
                    dp[i] = i > 1 ? dp[i-2] + 2 : 2;
                 }else if (i-1 >= dp[i-1] && array[i-1-dp[i-1]] == '('){
                    dp[i] = dp[i-1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) +2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
}
