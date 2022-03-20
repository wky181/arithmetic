package LeetCodeSecond.stack;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/6/3 21:40
 * @Description:
 */
public class MyQueue {
    /** Initialize your data structure here. */
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;
    private int size;
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.add(x);
        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outputStack.isEmpty()){
            return outputStack.pop();
        }
        while (!inputStack.isEmpty()){
            outputStack.add(inputStack.pop());
        }
        if (outputStack.isEmpty()){
            throw new RuntimeException("no value");
        }
        size--;
        return outputStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!outputStack.isEmpty()){
            return outputStack.peek();
        }
        while (!inputStack.isEmpty()){
            outputStack.add(inputStack.pop());
        }
        if (outputStack.isEmpty()){
            throw new RuntimeException("no value");
        }
        return outputStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }
}
