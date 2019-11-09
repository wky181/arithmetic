package data_structure.stack.stack_problem;

import data_structure.list.DoubleLinkList;
import data_structure.list.ListNode;
import data_structure.stack.IStack;
import data_structure.stack.linkStack.MyStack;

import java.util.EmptyStackException;

/**
 * @author 武凯焱
 * @date 2019/11/7 17:32
 * @Description: 实现一个栈 可以返回栈中最小值
 */
public class MinStack<T> extends DoubleLinkList<T> implements IStack<T> {
    private MyStack<Integer> brother = new MyStack<>();
    @Override
    public void push(T e) {
        super.add(e);
        if (brother.empty()){
            brother.add((Integer) e);
        }else {
            Integer integer = brother.peek();
            brother.add(integer>(Integer) e? (Integer) e :integer);
        }
    }

    @Override
    public T pop() {
        if (size<=0){
            throw new EmptyStackException();
        }
        ListNode<T> the  = super.last.getPer();
        T res = the.getData();
        the.getPer().setNext(last);
        last.setPer(the.getPer());
        the.setPer(null);
        the.setNext(null);
        size--;
        brother.pop();
        return res;
    }
    @Override
    public boolean empty() {
        return getSize()==0;
    }
    @Override
    public int getSize() {
        return super.size;
    }

    @Override
    public T peek() {
        return (T) last.getPer().getData();
    }
    public Integer min(){
        return brother.peek();
    }
}
