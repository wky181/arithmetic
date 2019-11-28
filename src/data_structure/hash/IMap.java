package data_structure.hash;

import java.util.Map;

/**
 * @author 武凯焱
 * @date 2019/11/27 8:42
 * @Description:
 */
public interface IMap<K,V>  {

    /**
     * 清楚键值对
     */
    void clear();



    /**
     * map是否为空
     */
    boolean isEmpty();

    /**
     *
     * @return map 的大小
     */
    int size();

    /**
     * 是否包含指定key的键值对
     * @param key
     * @return
     */
    boolean containsKey(Object key);

    /**
     * 是否包含指定value的键值对
     * @param value
     * @return
     */
    boolean containsValue(Object value);

    void put(K k,V v);

    /**
     * 把另外一个map中的所有键值对放入当前map
     * @param m
     */
    void putAll(Map<? extends K, ? extends V> m);

    /**
     *
     * @return 返回当前map所有key
     */
    K[] keySet();

    /**
     *
     * @return  返回当前map所有value
     */
    V[] values();

    /**
     * 根据key取值
     * @param key
     * @return
     */
    V get(Object key);

    /**
     * 根据key移除
     * @param key
     * @return
     */
    V remove(Object key);






}
