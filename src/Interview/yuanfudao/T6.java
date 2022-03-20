package Interview.yuanfudao;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/8/9 10:39
 * @Description:
 */
public class T6 {
    public String makeGood(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < array.length ; i++) {
            if (!stack.isEmpty()){
                if (Math.abs(stack.peek() - array[i]) == 32 ){
                    stack.pop();
                    continue;
                }
            }
            stack.push(array[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.insert(0,stack.pop());
        }
        return stringBuilder.toString();
    }
}
