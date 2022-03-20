package LeetCodeSecond.offer;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/6/25 9:32
 * @Description:
 */
public class LeetCode_35 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        return copyRandomList(head, map);
    }

    // 深度拷贝当前节点, 返回拷贝后的结点
    public Node copyRandomList(Node head, HashMap<Node, Node> map) {
        if (head == null) {
            return head;
        }
        Node node = new Node(head.val);
        map.put(head, node);
        // 如果当前的random节点还没被拷贝过，递归拷贝random节点，返回拷贝后的节点
        if (!map.containsKey(node.random)) {
            copyRandomList(node.random, map);
        }
        // 如果当前的next节点还没被拷贝过，递归拷贝next节点，返回拷贝后的节点
        if (!map.containsKey(head.next)) {
            copyRandomList(head.next, map);
        }
        node.random = map.get(head.random);
        node.next = map.get(head.next);
        return node;
    }

    // 原地复制链表, 然后对链表进行拆分，返回拆分后的链表
    public Node copyRandomList1(Node head) {
        if (head == null){
            return head;
        }
        // 复制
        Node tmp = head;
        while (tmp != null) {
            Node node = new Node(tmp.val);
            node.random = tmp.random;
            // 插入复制的节点
            node.next = tmp.next;
            tmp.next = node;
            tmp = node.next;
        }
        // 让复制的节点的random也指向复制的节点，也就是原来的节点的下一个节点
        tmp = head;
        while (tmp != null) {
            tmp.next.random = tmp.random == null ? null : tmp.random.next;
            tmp = tmp.next.next;
        }

        // 分离复制好的链表，并维持原来的链表不变
        Node res = head.next;
        tmp = res;
        head.next = head.next.next;
        head = head.next;
        while (head != null) {
            // 复制的链表
            tmp.next = head.next;
            tmp = tmp.next;
            // 恢复原来链表
            head.next = head.next.next;
            head = head.next;

        }
        return res;
    }
}
