package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/3/1 23:33
 * @Description:
 */
public class MyStack {
    Queue<Integer> q1 = new LinkedList();
    Queue<Integer> q2 = new LinkedList();
    /** Initialize your data structure here. */
    int x;
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        this.x = x;

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1){
            x = q1.poll();
            q2.offer(x);
        }
        Integer poll = q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return poll;
    }

    /** Get the top element. */
    public int top() {
        return x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
