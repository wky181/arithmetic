package data_structure.stack.stack_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 武凯焱
 * @date 2019/11/26 22:04
 * @Description:
 */
public class TwoSatckSort {
    public ArrayList<Integer> twoSatckSort(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);

        }
        Stack<Integer> stack1 = new Stack<>();
        while (!stack.empty()) {
            int num = stack.pop();
            if (stack1.empty()) {
                stack1.push(num);
            } else {
                while (!stack1.empty() && stack1.peek() < num) {
                   stack.push( stack1.pop());
                }
                stack1.push(num);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack1.empty()){
            list.add(stack1.pop());
        }
        return list;
    }
}
