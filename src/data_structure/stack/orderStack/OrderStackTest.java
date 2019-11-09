package data_structure.stack.orderStack;

/**
 * @author 武凯焱
 * @date 2019/10/14 17:19
 * @Description:
 */
public class OrderStackTest {
    public static void main(String[] args) {
        MyOrderStack<Integer> minStack = new MyOrderStack<Integer>();
        for (int i = 0; i <100 ; i++) {
            minStack.push(i);
        }
        System.out.println("弹出栈顶元素"+minStack.pop());
        System.out.println("查看栈顶元素"+minStack.peek());
        System.out.println(minStack.getSize());
    }
}
