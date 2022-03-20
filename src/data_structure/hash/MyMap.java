package data_structure.hash;


/**
 * @Author: wky233
 * @Date: 2020/9/10 15:54
 * @Description:
 */
public class MyMap<K, V>{
    private int size;
    private int capacity;
    private Node[] tables;

    public MyMap(int capacity) {
        this.capacity = capacity;
        tables = new Node[capacity];
    }
    public void put(K key, V value){
        Node node = new Node();
        int index = hash(key);
        if (tables[index] == null){
            tables[index] = node;
        }else {
            Node p = tables[index];
            while (p != null){
                if (p.key == key || p.key.equals(key) ){
                    p.value = value;
                    break;
                }
                if (p.next == null){
                    p.next = node;
                    size++;
                    break;
                }else {
                    p = p.next;
                }
            }
        }
    }
    public V remove(K key){
        int index = hash(key);
        if (tables[index] == null){
            return null;
        }
        Node p = tables[index];
        if (key == p.key || (key.hashCode() == p.key.hashCode() && key.equals(p.key))){
            tables[index] = null;
            size--;
            return (V) p.value;
        }
        Node pre = p;
        p = p.next;
        while (p != null){
            if (key == p.key || (key.hashCode() == p.key.hashCode() && key.equals(p.key))){
                pre.next = p.next;
                size--;
                return (V) p.value;
            }
            p = p.next;
        }
        return null;
    }
    public V get(K key){
        int index = hash(key);
        Node p = tables[index];
        while (p != null){
            if (p.key == key || (key.hashCode() == p.key.hashCode() && key.equals(p.key))){
                return (V) p.value;
            }
            p = p.next;
        }
        return null;
    }
    private int hash(K key) {
        if (key == null){
            return 0;
        }
        int h = 0;
        String s = key.toString();
        for (int i = 0; i < s.length(); i++) {
            h = 31 * h + s.charAt(i);
        }
        return h % capacity;
    }

    public class Node<K ,V>{
        Node next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public Node() {
        }
    }
}
