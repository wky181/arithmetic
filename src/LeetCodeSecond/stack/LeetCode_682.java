package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/4 0:01
 * @Description:
 */
public class LeetCode_682 {
    public int calPoints(String[] ops) {
        Deque<Integer> deque = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < ops.length ; i++) {
            String mark = ops[i];
            switch (mark){
                case "+":
                    int top = deque.pollLast();
                   int sum = top + deque.peekLast();
                   deque.addLast(top);
                   deque.addLast(sum);
                   break;
                case "D":
                    deque.addLast(deque.peekLast()*2);
                    break;
                case "C":
                    deque.pollLast();
                    break;
                default:
                    deque.addLast(Integer.parseInt(mark));
            }
        }
        while (!deque.isEmpty()){
            res += deque.pollLast();
        }
        return res;
    }
}
