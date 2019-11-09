package data_structure.quene.linkquene;

import data_structure.list.DoubleLinkList;
import data_structure.list.ListNode;
import data_structure.quene.IQuene;

/**
 * @author 武凯焱
 * @date 2019/11/7 16:00
 * @Description: 自己实现队列
 */
public class MyLinkQuene<T>  extends DoubleLinkList implements IQuene<T>  {
    @Override
    public void enquene(T e) {
        super.add(e);
    }

    @Override
    public T dequene() {
        if (size>0) {
            ListNode<T> listNode = first.getNext();
            first.setNext(listNode.getNext());
            listNode.getNext().setPer(first);
            listNode.setNext(null);
            listNode.setPer(null);
            size--;
            return listNode.getData();
        }
        else {
            throw new RuntimeException("队列已空");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public T peek() {
        return (T) first.getNext().getData();
    }
}
