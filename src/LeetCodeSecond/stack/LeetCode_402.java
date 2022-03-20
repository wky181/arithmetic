package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/1 0:11
 * @Description:
 */
public class LeetCode_402 {
    public String removeKdigits(String num, int k) {
        char[] array = num.toCharArray();
        //维护单调递增栈
        Deque<Character> deque = new ArrayDeque<>(num.length());
        for (int i = 0; i < array.length ; i++) {
            // 如果发现有小于栈顶的,移除栈顶
            while (!deque.isEmpty() && array[i] < deque.peekLast() && k > 0){
                deque.pollLast();
            }
            deque.addLast(array[i]);
        }
        // 如果k>0,移除栈顶元素
        while (k > 0 && !deque.isEmpty()){
            deque.pollLast();
            k--;
        }
        while (!deque.isEmpty() && deque.peek() == '0'){
            deque.poll();
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.poll());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
