package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/5/31 21:17
 * @Description:
 */
public class LeetCode_739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0){
            return new int[0];
        }
        int[] res = new int[T.length];
        // 单调栈 存储元素下标 单调递减栈
        Deque<Integer> deque =new ArrayDeque(T.length);
        for (int i = T.length-1; i >= 0 ; i--) {
            // 只要当前温度大于等于栈顶元素就弹出
            while (!deque.isEmpty() && T[i] >= T[deque.peekLast()]){
                    deque.pollLast();
            }
            // 如果栈顶不为空，那么当前元素的最近上升元素就是栈顶元素
            if (!deque.isEmpty()){
                res[i] = deque.peekLast() - i;
            }
            deque.addLast(i);
        }
        return res;
    }
    // 单调栈
    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0){
            return new int[0];
        }
        int[] res = new int[T.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = T.length - 1; i >= 0 ; i--) {
            while (!deque.isEmpty() && T[i] >= T[deque.peekLast()]){
                    deque.pollLast();
            }
            if (!deque.isEmpty()){
                res[i]  = deque.peekLast() - i;
            }
            deque.addLast(i);
        }
        return res;
    }
}
