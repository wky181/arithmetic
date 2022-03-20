package LeetCodeSecond.offer2;

import LeetCodeSecond.offer.Node;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/9/16 15:03
 * @Description:
 */
public class offer35 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> memo = new HashMap<>();
        Node cur = head;
        while (cur != null){
            memo.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            Node node = memo.get(cur);
            node.next = memo.get(node.next);
            node.random = memo.get(node.random);
            cur = cur.next;
        }
        return memo.get(head);
    }
    public Node copy(HashMap<Node, Node> memo, Node head){
        if (head == null){
            return null;
        }
        Node newNode = new Node(head.val);
        memo.put(head, newNode);
        if (!memo.containsKey(head.random)){
            copy(memo,head.random);
        }
        if (!memo.containsKey(head.next)){
            copy(memo, head.next);
        }
        newNode.random = memo.get(head.random);
        newNode.next = memo.get(head.next);
        return newNode;
    }
}
