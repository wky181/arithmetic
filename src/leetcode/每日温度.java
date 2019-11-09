package leetcode;

import java.util.Stack;

/**
 * @author 武凯焱
 * @date 2019/8/10 16:08
 * @Description:
 */
public class 每日温度 {
    public static void main(String[] args) {

    }
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i <T.length ; i++) {
            while (!stack.isEmpty() && T[i]>T[stack.peek()]){
                //当前元素为栈顶元素的第一个最大值
                int temp = stack.pop();
                res[temp] = i-temp;
            }
            //如果当前元素比栈顶元素小 则入栈 成为栈顶
            stack.push(i);
        }
        return res;
    }
}
