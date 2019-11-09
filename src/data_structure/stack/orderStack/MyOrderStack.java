package data_structure.stack.orderStack;

import data_structure.stack.IStack;

/**
 * @author 武凯焱
 * @date 2019/10/14 16:38
 * @Description: 顺序栈的实现
 */
public class MyOrderStack<T> implements IStack {
    private T[] elements;
    private int capacity = 10;
    //栈底下标
    private int base =0;
    //栈顶下标
    private int top = 0;
    private int size = 0;
    public MyOrderStack(int capacity){
        this.capacity = capacity;
        this.elements = (T[]) new Object [capacity];

    }
    public MyOrderStack(){
        this.elements = (T[]) new Object [capacity];
    }
    @Override
    public void push(Object e) {
        //判断数组是否已满
        if (top==capacity){
            //建立一个是原来空间二倍的数组
          capacity = capacity *2;
          T[] temp = (T[]) new Object[capacity];
            for (int i = 0; i <elements.length ; i++) {
                //将原来数组元素挪进新数组
                temp [i] = elements [i];
            }
            elements = temp;
        }
        elements [top++] = (T) e;
        size++;
    }

    @Override
    public Object pop() {
        if (top == base){
            throw new RuntimeException("栈空");
        }
        size--;
        return elements [--top];
    }

    @Override
    public boolean empty() {
        return top == base;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object peek() {
        return elements [top-1];
    }
}
