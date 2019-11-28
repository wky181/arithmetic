package data_structure.hash;

import java.util.Map;

/**
 * @author 武凯焱
 * @date 2019/11/27 9:03
 * @Description:
 */
public class MyHashMap<K, V> implements IMap<K, V> {
    private Node[] barrel = new Node[16];

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public void put(K k, V v) {
        Node<K, V> node = new Node<K, V>(k, v);
        int index = hash(k);
        if (barrel[index] == null) {
            barrel[index] = node;
        }
        Node p = barrel[index];
        while (p != null) {
            if (p.key == k || p.key.equals(k)){
                p.value = v;
                break;
            }
            if (p.next==null){
                p.next = node;
                break;
            }else {
                p = p.next;
            }
        }

    }

    private int hash(K k) {
        return k.hashCode() % 16;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public K[] keySet() {
        return null;
    }

    @Override
    public V[] values() {
        return null;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    private class Node<K, V> {
        Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
    }
}
