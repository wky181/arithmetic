package test;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/8/13 19:47
 * @Description:
 */
public class blibli1 {
    public boolean IsValidExp (String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0){
            return true;
        }
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']') ){
                return false;
            }
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if (c == ')'){
                if (stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }
            else if (c == ']'){
                if (stack.peek() == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }
            else if (c == '}'){
                if (stack.peek() == '{'){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
