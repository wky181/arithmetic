package data_structure.hash;

import java.util.HashSet;

public interface IHashSet<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean add(E e);

    boolean remove(Object o);

    void  clear();
}
