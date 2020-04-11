package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/17 12:25
 * @Description:
 */
public class LeetCode_20 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_20().isValid("(])"));
    }
    public boolean isValid(String s) {
        if (s == null || s .equals("")){
            return true;
        }
      Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                char match;
               if (ch == ')'){
                   match = '(';
               }else if (ch == '}'){
                   match = '{';
               }else if (ch == ']'){
                   match = '[';
               }else {
                   return false;
               }
               if (!character.equals(match)){
                   return false;
               }
            }
        }
        return stack.isEmpty();
    }
}
