package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/3 21:20
 * @Description:
 */
public class LeetCode_20 {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '['){
                deque.addLast(array[i]);
            }else if (array[i] == ')'){
                if (deque.isEmpty() || deque.pollLast() != '('){
                    return false;
                }
            }else if (array[i] == ']'){
                if (deque.isEmpty() || deque.pollLast() != '['){
                    return false;
                }
            }else if (array[i] == '}'){
                if (deque.isEmpty() || deque.pollLast() != '{'){
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }
}
