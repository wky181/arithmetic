package data_structure.list.link_problem;

/**
 * @author 武凯焱
 * @date 2019/7/30 16:36
 * @Description: 求倒数第k个节点
 */
public class ThkNode {
    private static class Node {
        Node next;
        Object data;

        public Node(Object data) {
            this.data = data;
        }
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
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 78, 7, 5, 2};
        //哑元
        Node head = new Node(null);
        Node last = head;
        for (int i = 0; i < arr.length; i++) {
            last.next = new Node(arr[i]);
            last = last.next;
        }
        System.out.println(getThk(head,7));
        System.out.println(head.toString());
      /*  Node p = head.next;
        while (p!=null){
            System.out.println(p.data);
            p = p.next;
        }*/
    }

    private static Object getThk(Node head, int k) {
        if (head.next==null || k<=0){
            return null;
        }
        Node p = head.next;
        Node p1 = p;
        for (int i = 0; i < k; i++) {
            if (p1==null){
                return null;
            }
            p1 = p1.next;
        }
        while (p1 != null) {
            p = p.next;
            p1 = p1.next;
        }
        return p.data;
    }
}