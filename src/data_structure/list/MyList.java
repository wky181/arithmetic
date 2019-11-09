package data_structure.list;

import java.util.Iterator;

/**
 * @author 武凯焱
 * @date 2019/7/23 16:24
 * @Description:
 */
public interface MyList<T> extends Iterator {
    void add(T element);

    /**
     * 删除一个相同元素
     *
     * @param element
     */
    void delete(T element);

    /**
     * 删除指定位置元素
     *
     * @param index
     */
    void delete(int index);

    /**
     * 更新指定位置元素
     *
     * @param index
     * @param newElement
     */
    void update(int index, T newElement);

    /**
     * 是否包含元素
     *
     * @param target
     * @return
     */
    boolean contains(T target);

    /**
     * 查询指定位置元素下标
     */
    int indexOf(T str);

    /**
     * 查询指定位置得元素
     * @param index
     * @return
     */
    T at (int index);


}
