package data_structure.stack.stack_problem;

import java.util.Stack;

/**
 * @author 武凯焱
 * @date 2019/11/26 21:32
 * @Description:
 */
public class Myquene<T> {
    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public void enqueue(T value){
        stack1.push(value);
    }
    public T departure(){
        move(stack1,stack2);
        T num =  stack2.pop();
        move(stack2,stack1);
        return num;
    }

    public void move(Stack<T> stack ,Stack<T> target) {
        while (!stack.isEmpty()){
            T integer = stack.pop();
            target.push(integer);
        }
    }
}
