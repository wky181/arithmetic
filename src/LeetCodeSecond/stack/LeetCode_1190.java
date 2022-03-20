package LeetCodeSecond.stack;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/8/7 20:47
 * @Description:
 */
public class LeetCode_1190 {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == '('){
                stack.push(i);
            }else if (array[i] == ')'){
                reverse(stack.pop() + 1, i - 1, array);
            }
        }
        for (int i = 0; i < array.length ; i++) {
            if (array[i] != '(' && array[i] != ')'){
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
    public void reverse(int left, int right, char[] arrays){
        while (left < right){
            char temp = arrays[left];
            arrays[left] = arrays[right];
            arrays[right] = temp;
            left++;
            right--;
        }
    }
}
