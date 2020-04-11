package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/18 9:43
 * @Description:
 *  数组最大长度为tokens.length / 2 + 1
 * switch代替if-else，效率优化
 * Integer.parseInt代替Integer.valueOf,减少自动拆箱装箱操作
 */
public class LeetCode_150 {
    public static void main(String[] args) {
        String[] string = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(new LeetCode_150().evalRPN(string));
    }
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1 ){
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length ; i++) {
            String string = tokens[i];
            if ("+".equals(string) || "-".equals(string) || "*".equals(string) || "/".equals(string)) {
                // 栈是先入后出，所以应该是 num2-num1 num2/num1
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (string) {
                    case"+":
                        stack.push((num1 + num2));
                        break;
                    case"-":
                        stack.push((num2 *- num1));
                        break;
                    case"*":
                        stack.push((num1 * num2));
                        break;
                    case"/":
                        stack.push((num2 / num1));
                        break;
                    default:
                        break;
            }
            }else {
                stack.push(Integer.parseInt(string));
            }
        }
        return stack.pop();
    }

}
