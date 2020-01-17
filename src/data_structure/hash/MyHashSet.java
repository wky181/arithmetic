package data_structure.hash;

import java.util.HashMap;
import java.util.Iterator;

public class MyHashSet<E>  implements IHashSet<E>  {
    private int capacity = 16 ;
    private MyHashMap myHashMap = new MyHashMap(capacity);
    @Override
    public int size() {
        return myHashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return myHashMap.isEmpty();
    }

    @Override
    public boolean contains(Object e) {
        return myHashMap.containsKey(e);
    }

    @Override
    public void add(E e) {
        myHashMap.put(e,null);
    }

    @Override
    public void remove(Object o) {
        myHashMap.remove(o);
    }

    @Override
    public void clear() {
        myHashMap.clear();
    }

    @Override
    public Iterator<E> iteraor() {
        Iterator<MyHashMap.Node> iter = myHashMap.iterator();
        Iterator<E> iterator = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public E next() {
                return (E) iter.next().key;
            }
        };
        return iterator;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<MyHashMap.Node> iterator = myHashMap.iterator();
        while (iterator.hasNext()){
            MyHashMap.Node node = (MyHashMap.Node) iterator.next();
            stringBuilder.append("key " +node.key+"," );
        }
        return stringBuilder.toString();
    }
}
