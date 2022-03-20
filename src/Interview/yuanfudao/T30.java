package Interview.yuanfudao;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/22 20:09
 * @Description:
 */
public class T30 {
    static Node root;
    static Node end;
    public static void main(String[] args) {
        root = new Node(-1);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        StringBuilder list = new StringBuilder();
        Node end = root;
        for (int i = 1; i <= N; i++) {
            end.next = new Node(i);
            end = end.next;
        }
        int[] method = new int[M];
        for (int i = 0; i < M ; i++) {
            method[i] = scanner.nextInt();
        }
        for (int i = 0; i < method.length ; i++) {
            int m = method[i];
            if (m == 0){
               Node node = root.next;
               root.next = node.next;
               end.next = node;
               node.next = null;
               end = node;
            }else {
                Node dummy = root.next;
                while (dummy != null && dummy.next != null){
                    int temp = dummy.value;
                    dummy.value = dummy.next.value;
                    dummy.next.value = temp;
                    dummy = dummy.next.next;
                }
            }
        }
       Node cur = root.next;
        LinkedList list1 = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder();
        while (cur != null){
            stringBuilder.append(cur.value + " ");
            cur = cur.next;
        }
        System.out.println(stringBuilder.toString());
    }
    public static class Node{
        int value;
        Node pre;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
