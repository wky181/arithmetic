package data_structure.list.link_problem;

/**
 * 实现一个算法 删除单向链表的某个节点，假定你只能访问该节点
 *
 * @author 武凯焱
 * @date 2019/7/30 17:31
 * @Description:
 */
public class RemoveNode {
    private static class Node {
        private Node next;
        private Object data;
        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("[");
            Node nnext = next;
            while (nnext!=null){
                stringBuilder.append(nnext.data);
                if (nnext.next!=null) {
                    stringBuilder.append(",");
                }
                nnext = nnext.next;
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        public Node(Object data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] arr = {48, 5, 6, 75, 12, 3, 74, 9, 8, 4};
        Node head = new Node(null);
        Node last = head;
        for (int i = 0; i < arr.length; i++) {
            last.next = new Node(arr[i]);
            last = last.next;
        }
        Node p = head.next.next.next.next;
        remove(p);
        System.out.println(head);

    }

    private static void remove(Node pnode) {
        if (pnode.next != null) {
            pnode.data = pnode.next.data;
            pnode.next = pnode.next.next;
        }
    }
}
