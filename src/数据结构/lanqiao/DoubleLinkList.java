package 数据结构.lanqiao;

/**
 * @author 武凯焱
 * @date 2019/7/25 9:03
 * @Description:
 */
public class DoubleLinkList implements MyList {
    ListNode first;
    ListNode last;
    int size;

    public DoubleLinkList() {
        //初始化前亚元
        first = new ListNode(null);
        //初始化后亚元
        last = new ListNode(null);
        first.next = last;
        last.per = first;
        now  = first;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        ListNode p = first.next;
        while (p != last) {
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
        //在亚元之间插入一个元素  需要改变四个指针的指向
        ListNode newNode = new ListNode(element);
        last.per.next = newNode;
        newNode.per = last.per;
        newNode.next = last;
        last.per = newNode;
        size++;

    }

    @Override
    public void delete(Object element) {
        ListNode p = first.next;
        while (p != last) {
            if (p.data.equals(element)) {
                p.per.next = p.next;
                p.next.per = p.per;
                p.next = null;
                p.per = null;
                size--;
                break;
            }
            p = p.next;
        }

    }

    @Override
    public void delete(int index) {
        if (index<0 || index>=size){
            return;
        }
        ListNode p = first.next;
        int i = 0;
        while (p!=last){
            if (i==index){
                p.per.next = p.next;
                p.next.per = p.per;
                p.next = null;
                p.per  = null;
                size--;
                break;
            }
            p = p.next;
            i++;
        }
    }

    @Override
    public void update(int index, Object newElement) {
        if (index<0 || index>=size){
            return ;
        }
        ListNode p = first.next;
        int i = 0;
        while (p != last) {
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
        ListNode p = first.next;
        while (p != last) {
            if (p.data.equals(target)){
                return true;
            }
            p= p.next;
        }
        return false;
    }

    @Override
    public int indexOf(Object str) {
        ListNode p = first.next;
        int i = 0;
        while (p != last) {
            if (p.data.equals(str)){
                return i;
            }
            p=p.next;
            i++;
        }
        return -1;
}

    @Override
    public Object at(int index) {
        if (index<0 || index>=size){
            return null;
        }
        ListNode p = first.next;
        int i = 0;
        while (p != last) {
            if (i == index) {
                return p.data;
            }
            p = p.next;
            i++;
        }
        return null;
    }

  private  ListNode now ;
    @Override
    public boolean hasNext() {
        return now.next!=last;
    }
    @Override
    public Object next() {
        now = now.next;
        return now.data;
    }
}
