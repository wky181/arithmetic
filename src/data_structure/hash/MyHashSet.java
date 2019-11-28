package data_structure.hash;

public class MyHashSet<E> implements IHashSet<E> {
    private MyHashMap myHashMap = new MyHashMap();
    @Override
    public int size() {
        return myHashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        myHashMap.put(e,null);
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }
}
