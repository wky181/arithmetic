package data_structure.list.link_problem;

/**
 * @author 武凯焱
 * @date 2019/7/30 20:42
 * @Description:
 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
 注意：分割以后保持原来的数据顺序不变。
 不要开辟新的空间，即不要新建节点
 */
public class ParrtionLinkNode {
    public static void main(String[] args) {
        int[] arr = {8,5,4,1,2,7};
        ListNode head = new ListNode(0);
        ListNode last = head;
        for (int i = 0; i < arr.length; i++) {
            last.next = new ListNode(arr[i]);
            last = last.next;
        }
        ListNode listNode = parrtion(head.next, 4);
        System.out.println(listNode.toString());

    }

    private static class ListNode {
        ListNode next;
        int data;

        public ListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(data);
            stringBuilder.append(",");
            ListNode nnext = next;
            while (nnext != null) {
                stringBuilder.append(nnext.data);
                if (nnext.next != null) {
                    stringBuilder.append(",");
                }
                nnext = nnext.next;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static ListNode parrtion(ListNode phead, int x) {
        ListNode p = phead;
        ListNode leftFirst = null;
        ListNode leftTail = null;
        ListNode rightFirst = null;
        ListNode rightTail = null;
        while (p != null) {
            if (p.data >= x) {
                if (rightFirst == null) {
                    rightFirst = p;
                    rightTail = p;
                } else {
                    rightTail.next = p;
                    rightTail = rightTail.next;
                }
            } else {
                if (leftFirst == null) {
                    leftFirst = p;
                    leftTail = p;
                } else {
                    leftTail.next = p;
                    leftTail = leftTail.next;
                }
            }
            p = p.next;
        }
        if (leftFirst == null) {
            return rightFirst;
        } else {
            leftTail.next = rightFirst;
        }
        if (rightTail != null) {
            rightTail.next = null;
        }
        return leftFirst;
    }
}
