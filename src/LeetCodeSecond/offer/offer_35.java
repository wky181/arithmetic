package LeetCodeSecond.offer;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/8/18 11:00
 * @Description:
 */
public class offer_35 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> memo = new HashMap<>();
        Node node = copyNode(head, memo);
        return node;
    }
    public Node copyNode(Node head, HashMap<Node,Node> memo){
        if (head == null){
            return head;
        }
        Node node = new Node(head.val);
        memo.put(head,node);
        if (!memo.containsKey(head.random)){
            copyNode(head.random,memo);
        }
        if (!memo.containsKey(head.next)){
            copyNode(head.next, memo);
        }
        node.next = memo.get(head.next);
        node.random = memo.get(node.random);
        return node;
    }
}
