package LeetCodeSecond.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/19 23:23
 * @Description:
 */
public class MinStack {

    /** initialize your data structure here. */

    Deque<Integer> store;
    Deque<Integer> min;
    public MinStack() {
        store = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void addLast(int x) {
        store.addLast(x);
        if (min.isEmpty() || min.peekLast() > x){
            min.addLast(x);
        }else {
            min.addLast(min());
        }
    }

    public void pop() {
        min.pollLast();
        store.pollLast();
    }

    public int top() {
        if (store == null){
            throw new RuntimeException("占空");
        }
        return store.peekLast();
    }

    public int min() {
        if (min == null){
            throw new RuntimeException("占空");
        }
        return min.peekLast();
    }
}
