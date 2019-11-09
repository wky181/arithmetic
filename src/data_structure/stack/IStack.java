package data_structure.stack;

/**
 * @author 武凯焱
 * @date 2019/7/31 18:10
 * @Description:
 */
public interface IStack<T> {
    /**
     * 元素入栈
     * @param e
     */
    void push(T e);

    /**
     * 弹出栈顶
     * @return
     */
    T pop();

    /**
     * 是否空栈
     */
    boolean empty();

    /**
     * 获得栈內元素个数
     * @return
     */
    int getSize();

    /**
     * 弹出栈顶元素
     * @return
     */
    T peek();

}
