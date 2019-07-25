package 数据结构.lanqiao;

/**
 * @author 武凯焱
 * @date 2019/7/23 21:55
 * @Description:
 */
public class SingleLinkedList implements MyList {
    private ListNode first;
    private ListNode last;
    private int size;

    @Override
    public void add(Object element) {
        if (first == null) {
            first = new ListNode(element);
            last = first;
        } else {
            last.next = new ListNode(element);
            last = last.next;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        ListNode p = first;
        while (p != null) {
            stringBuilder.append(p.data);
            if (p.next != null) {
                stringBuilder.append(",");
            }
            p = p.next;

        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void delete(Object element) {
        ListNode p = first;
        ListNode pre = null;
        while (p != null) {
            if (p.data.equals(element)) {
                if (pre == null) {
                    // 当正好第一个元素被匹配到的时候，让它和自己的下指针相等
                    first = first.next;
                } else {
                    pre.next = p.next;
                }
                size--;
            }
            pre = p;
            p = p.next;
        }

    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        int i = 0;
        ListNode p = first;
        ListNode per = null;
        while (p != null) {
            if (i == index) {
                if (per == null) {
                // 当正好第一个元素被匹配到的时候，让它和自己的下指针相等
                    first = first.next;
                } else {
                    per.next = p.next;
                }
                size--;
            }
            per = p;
            p = p.next;
            i++;
        }
    }

    @Override
    public void update(int index, Object newElement) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode p = first;
        int i = 0;
        while (p != null) {
            if (i == index) {
                p.data = newElement;
                break;
            }
            p = p.next;
            i++;
        }
    }

    @Override
    public boolean contains(Object target) {
        ListNode p = first;
        while (p != null) {
            if (target.equals(p.data)) {
                return true;
            }
            p = p.next;
    }
        return false;
    }
    @Override
    public int indexOf(Object str) {
        ListNode p = first;
        int i = 0;
        while (p != null) {
            if (str.equals(p.data)) {
                return  i;
            }else {
                i++;
                p = p.next;
            }

        }
        return -1;
    }

    @Override
    public Object at(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ListNode p = first;
        int i = 0;
        while (p != null) {
            if (i == index) {
                return p.data;
            }
            p = p.next;
            i++;
        }
        return null;
    }
}
