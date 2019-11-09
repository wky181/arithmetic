package data_structure.list.link_problem;

import java.util.HashSet;

/**
 * @author 武凯焱
 * @date 2019/7/30 11:20
 * @Description:
 */
public class DeleteDuplicateNode {

    public static void main(String[] args) {
        int[] arr = {45,7,7,8,7,97,7,7,7,9,7};
        //哑元
        Node head = new Node(null);
        Node last = head;
        for (int i = 0; i < arr.length ; i++) {
            last.next  = new Node(arr[i]);
            last = last.next;
        }
        remove(head);
        Node p = head.next;
        while (p!=null){
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println(head.toString());
    }
    private static void remove(Node head){
        Node p = head.next;
        HashSet set = new HashSet();
        while (p!=null){
            if (set.contains(p.data)){
                head.next = p.next;
            }else {
                set.add(p.data);
                head = p;
            }

            p = p.next;
        }

    }


    private static class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }


    }
}
