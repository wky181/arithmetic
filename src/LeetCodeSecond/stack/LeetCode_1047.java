package LeetCodeSecond.stack;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/7/14 22:16
 * @Description:
 */
public class LeetCode_1047 {
    public String removeDuplicates(String S) {
        if (S == null || S.length() <= 1){
            return S;
        }
        Stack<Character> stack = new Stack<>();
        char[] array = S.toCharArray();
        stack.push(array[0]);
        for (int i = 1; i < array.length ; i++) {
            while (!stack.isEmpty() && stack.peek().equals(array[i])){
                stack.pop();
            }
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
