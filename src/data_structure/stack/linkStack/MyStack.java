package data_structure.stack.linkStack;

import data_structure.list.DoubleLinkList;
import data_structure.list.ListNode;
import data_structure.stack.IStack;

import java.util.EmptyStackException;

/**
 * @author 武凯焱
 * @date 2019/7/31 18:18
 * @Description:
 */
public class MyStack<T> extends DoubleLinkList<T> implements IStack<T> {
    @Override
    public void push(T e) {
        super.add(e);
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
}
