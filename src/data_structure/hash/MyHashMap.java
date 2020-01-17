package data_structure.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 武凯焱
 * @date 2019/11/27 9:03
 * @Description:
 */
public class MyHashMap<K, V> implements IMap<K, V> {
    private int size;
    private int capacity = 16;
    private Node[] barrel = new Node[capacity];

    @Override
    public void clear() {
        for (Node node : barrel) {
            node = null;
            size--;
        }
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
    }

    public MyHashMap() {
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        int index = hash(key);
        if (barrel[index] == null) {
            return false;
        }
        Node<K, V> p = barrel[index];
        while (p != null) {
            if (p.key == key || (p.key.hashCode() == key.hashCode() && p.key.equals(key))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        V v;
        Node<K, V> node;
        if (barrel != null && size > 0) {
            for (int i = 0; i < barrel.length; i++) {
                if (barrel[i] != null) {
                    node = barrel[i];
                    while (node != null) {
                        if ((v = node.value) == value || (value != null && value.equals(v))) {
                            return true;
                        }
                        node = node.next;
                    }
                }
            }
        }
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
            if (p.key == k || (p.key.hashCode() == k.hashCode() && p.key.equals(k))) {
                p.value = v;
                break;
            }
            if (p.next == null) {
                p.next = node;
                break;
            } else {
                p = p.next;
            }
        }
        size++;

    }

    private int hash(K key) {
        if (key == null) {
            return (new String("null").hashCode()) % capacity;
        }
        //取余法
        //return key.hashCode() % capacity;
        int h = 0;
        // 素数
        int seed = 31;
        String s = key.toString();
        for (int i = 0; i != s.length(); i++) {
            h = seed * h + s.charAt(i);
        }
        return h % capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : barrel) {
            while (node != null) {
                stringBuilder.append("key " + node.key + " value " + node.value + ",");
                node = node.next;
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public MyHashSet<K> keySet() {
        MyHashSet<K> set = new MyHashSet<>();
        for (Node node : barrel) {
            while (node != null) {
                set.add((K) node.key);
                node = node.next;
            }
        }
        return set;
    }

    @Override
    public V[] values() {
        return null;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        if (barrel[index] == null) {
            return null;
        }
        Node<K, V> p = barrel[index];
        while (p != null) {
            if (p.key == key || (p.key.hashCode() == key.hashCode() && p.key.equals(key))) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        if (barrel[index] == null) {
            return null;
        }
        Node<K, V> p = barrel[index];
        if (p.key == key || (p.key.hashCode() == key.hashCode() && p.key.equals(key))) {
            barrel[index] = null;
            size--;
            return p.value;
        }
        Node per = p;
        while (p != null) {
            if (p.key == key || (p.key.hashCode() == key.hashCode() && p.key.equals(key))) {
                per.next = p.next;
                size--;
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator<Node> {
        int i = 0;
        Node p = barrel[i];
        @Override
        public boolean hasNext() {
            while (i < capacity-1 && p == null){
                p = barrel[++i];
            }
                return p != null;
        }

        @Override
        public Node next() {
            Node res = p ;
            p = p.next;
            return res;
        }
    }

    public class Node<K, V> {
        Node next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
