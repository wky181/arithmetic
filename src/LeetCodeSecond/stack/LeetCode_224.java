package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/6/3 22:44
 * @Description:
 */
public class LeetCode_224 {
    public int calculate(String s) {
        char[] arrays = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length() ; i++) {
            deque.add(arrays[i]);
        }
        return calculate(deque);
    }
    public int calculate(Deque<Character> deque) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int sum = 0;
        while (!deque.isEmpty()) {
            char charAt = deque.poll();
            if (Character.isDigit(charAt)){
                sum = sum * 10 + charAt - '0';
                continue;
            }
            if (charAt == '('){
                sum = calculate(deque);
            }
            //deque.size() == 0 最后一个是数字
            if (charAt != ' ' || deque.size() == 0){
                switch (sign){
                    case '+':
                        stack.push(sum);
                        break;
                    case '-':
                        stack.push(-sum);
                        break;
                    case '*':
                       stack.push(stack.pop() * sum);
                       break;
                    case '/':
                        stack.push(stack.pop() / sum);
                        break;
                    default:
                        break;
                }
                sign = charAt;
                sum = 0;
            }
            if (charAt == ')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
