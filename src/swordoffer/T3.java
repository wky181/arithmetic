package swordoffer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: wky233
 * @Date: 2020/8/27 20:29
 * @Description:
 */
public class T3 {
    static Node head;
    static Node tail;
    static HashMap<Integer, Node> memo;
    public static void main(String[] args) {
        head = new Node(-1);
        tail = new Node(-1);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        head.next = tail;
        tail.pre = head;
        memo = new HashMap<>();
        for (int i = 0; i < n ; i++) {
            int op = sc.nextInt();
            if (op == 1){
                insert(sc.nextInt(),sc.nextInt());
            }else if (op == 2){
                del(sc.nextInt());
            }else {
                toStr();
            }
        }
    }
    private static class Node{
        int val;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void insert(int index, int val){
        int i = 1;
        Node cur = head;
        while (i < index){
            cur = cur.next;
            i++;
        }
        Node nNode = new Node(val);
        nNode.next = cur.next;
        cur.next.pre = nNode;
        cur.next = nNode;
        nNode.pre = cur;
        memo.put(val,nNode);
    }
    public static void del(int val){
        Node node = memo.get(val);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        memo.remove(val);
    }
    public static void toStr(){
        Node cur = head.next;
        while (cur != tail){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
