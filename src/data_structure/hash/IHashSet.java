package data_structure.hash;


import java.util.Iterator;

public interface IHashSet<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    void add(E e);

    void remove(Object o);

    void  clear();

    Iterator<E> iteraor();
}
