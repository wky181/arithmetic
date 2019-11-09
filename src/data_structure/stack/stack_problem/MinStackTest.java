package data_structure.stack.stack_problem;

/**
 * @author 武凯焱
 * @date 2019/11/7 17:49
 * @Description:
 */
public class MinStackTest {
    public static void main(String[] args) {
        MinStack<Integer> minStack = new MinStack<>();
        minStack.push(9);
        minStack.push(1);
        minStack.push(3);
        minStack.push(0);
        minStack.push(10);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
    }
}
