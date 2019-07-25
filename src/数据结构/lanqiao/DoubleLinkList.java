package 数据结构.lanqiao;

/**
 * @author 武凯焱
 * @date 2019/7/25 9:03
 * @Description:
 */
public class DoubleLinkList implements  MyList{
    ListNode first;
    ListNode last;
    int size;

    public DoubleLinkList() {
        first = new ListNode(null);
        last = new ListNode(null);
        first.next = last;
        last.per = first;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        ListNode p = first.next;
        while (p!=last){
            str.append(p.data);
            if (p != last.per) {
                str.append(",");
            }
            p = p.next;
        }
        str.append(']');
        return str.toString();
    }
    @Override
    public void add(Object element) {
        ListNode newNode = new ListNode(element);
        last.per.next= newNode;
        newNode.per = last.per;
        newNode.next = last;
        last.per = newNode;
        size++;

    }

    @Override
    public void delete(Object element) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public void update(int index, Object newElement) {

    }

    @Override
    public boolean contains(Object target) {
        return false;
    }

    @Override
    public int indexOf(Object str) {
        return 0;
    }

    @Override
    public Object at(int index) {
        return null;
    }
}
