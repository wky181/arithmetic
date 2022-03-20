package swordoffer;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/8/27 22:05
 * @Description:
 */
public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
          return stack2.pop();
        }else {
            if (stack1.isEmpty()){
                //throw new RuntimeException("stack is empty");
                return -1;
            }
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
