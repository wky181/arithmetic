package data_structure.list;


/**
 * @author 武凯焱
 * @date 2019/7/23 16:47
 * @Description:
 */
public class MyArrayList<T> implements MyList<T> {
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i <size ; i++) {
            stringBuilder.append(i==size-1? elements[i]+"]" : elements[i]+",");
        }

        return stringBuilder.toString();
    }

    private T[] elements;
    private int capacity = 10;
    //元素个数
    private int size = 0;

    public MyArrayList (int capacity){
        this.capacity = capacity;
    }
    public MyArrayList() {
        this.elements = (T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        if (size==capacity){
            capacity = capacity*2;
            T[] arrs = (T[]) new Object[capacity];
            for (int i = 0; i <size ; i++) {
                arrs[i] = elements[i];
            }
            //替换掉旧的
            elements = arrs;
        }
        elements[size++] = element;
    }

    @Override
    public void delete(T element) {

    }

    @Override
    public void delete(int index) {
        for (int i = index; i <size-1 ; i++) {
            //从删除的位置开始都往前挪一位
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
    }

    @Override
    public void update(int index, T newElement) {
        elements[index] = newElement;
    }

    @Override
    public boolean contains(T target) {
        return indexOf(target)>=0;
    }

    @Override
    public int indexOf(T str) {
        for (int i = 0; i <size ; i++) {
            if (elements[i].equals(str)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public T at(int index) {
        return elements[index];

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
