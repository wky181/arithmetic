package test;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/9/14 14:35
 * @Description:
 */
public class SP1 {
    public static void main(String[] args) {
        System.out.println(longestValidParenthe("(()"));
    }
    static int longestValidParenthe(String s) {
        char[] array = s.toCharArray();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < array.length ; i++) {
            char c = array[i];
            if (c == ')'){
                Integer pop = stack.pop();
                if (!stack.isEmpty()){
                    max = Math.max(max, i - stack.peek());
                }else {
                    stack.push(i);
                }
            }else {
                stack.push(i);
            }
        }
        return max;
    }
}
