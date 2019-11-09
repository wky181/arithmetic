package data_structure.quene;

/**
 * @author 武凯焱
 * @date 2019/11/7 15:42
 * @Description: 队列接口
 */
public interface IQuene<T> {
    /**
     *入队
     */
    void enquene(T e);
    /**
     * 出队
     */
    T dequene();
    /**
     * 返回队列大小
     */
    int getSize();
    /**
     * 判断队列是否为空
     */
    boolean empty();
    /**
     * 取队首元素
     */
    T peek();


}
