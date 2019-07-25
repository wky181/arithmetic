package 数据结构.lanqiao;

/**
 * @author 武凯焱
 * @date 2019/7/23 16:24
 * @Description:
 */
public interface MyList {
    void add(Object element);

    /**
     * 删除一个相同元素
     *
     * @param element
     */
    void delete(Object element);

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
    void update(int index, Object newElement);

    /**
     * 是否包含元素
     *
     * @param target
     * @return
     */
    boolean contains(Object target);

    /**
     * 查询指定位置元素下标
     */
    int indexOf(Object str);

    /**
     * 查询指定位置得元素
     * @param index
     * @return
     */
    Object at (int index);


}
