package LeetCodeSecond.stack;

import bluebridgecup_course.class_03.最小可用id;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/6/3 21:55
 * @Description:
 */
public class LeetCode_844 {
    public boolean backspaceCompare(String S, String T) {
       return build(S).equals(build(T));
    }
    public String build(String s){
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length ; i++) {
            if (array[i] == '#' && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            stack.add(array[i]);

        }
        return String.valueOf(stack);
    }

}
