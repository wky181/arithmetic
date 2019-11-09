package data_structure.list.link_problem;

/**
 * @author 武凯焱
 * @date 2019/7/31 15:55
 * @Description: 有两个用链表表示的整数，每个结点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表的首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 * 测试样例：
 * {1,2,3},{3,2,1}
 * 返回：{4,4,4}
 * <p>
 * {7,4,0,7,5},{2,7,2,3,4}
 * 返回：{9,1,3,0,0,1}
 */
public class PlusLinkNode {
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

    public static void main(String[] args) {
        int[] arra = {7, 5, 4, 1, 5};
        int[] arrb = {4, 5, 6, 4, 8};
        ListNode haedA = new ListNode(0);
        ListNode lastA = haedA;
        ListNode haedB = new ListNode(0);
        ListNode lastB = haedB;
        for (int i = 0; i < arra.length; i++) {
            lastA.next = new ListNode(arra[i]);
            lastA = lastA.next;
        }
        for (int i = 0; i < arrb.length; i++) {
            lastB.next = new ListNode(arrb[i]);
            lastB = lastB.next;
        }
        ListNode node = plusAB(haedA.next,haedB.next,0);
        System.out.println(node.toString());

    }

    public static ListNode plusAB(ListNode a, ListNode b, int i) {
        if (a == null && b == null && i == 0) {
            return null;
        }
        int value = 0;
        value += i;
        if (a != null) {
            value += a.data;
            a = a.next;
        }
        if (b != null) {
            value += b.data;
            b = b.next;
        }
        i = value >= 10 ? 1 : 0;
        value = value%10;
        ListNode result = new ListNode(value);
        result.next = plusAB(a, b, i);
        return result;
    }

}
