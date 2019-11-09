package data_structure.list;

/**
 * @author 武凯焱
 * @date 2019/7/23 21:41
 * @Description:
 */
public class ListNode<T> {
    T data;
    ListNode next;
    ListNode per;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPer(ListNode per) {
        this.per = per;
    }

    public ListNode getNext() {

        return next;
    }

    public ListNode<T> getPer() {
        return per;
    }

    public ListNode(T data) {
        this.data = data;
    }
}
