package data_structure.list.link_problem;

/**
 * @author 武凯焱
 * @date 2019/7/31 17:26
 * @Description:
 */
/**
 * 给定一个有环链表，实现一个算法返回环路的开头结点
 *
 * 有环链表的定义：
 * 在链表中某个结点的next元素指向在它前面出现过的节点，则表明该链表存在环路
 * */
public class CircleLinkedList {
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
    }
}
