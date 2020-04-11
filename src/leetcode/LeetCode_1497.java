package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/3/11 14:12
 * @Description:
 */
public class LeetCode_1497 {
    public static void main(String[] args) {

    }
    Stack<Integer> stack1;
    Stack<Integer> stack2 ;
    public LeetCode_1497() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()){
           return -1;
        }
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
