package LeetCodeSecond.linkedlist;

import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/7/30 17:49
 * @Description:
 */
public class LeetCode_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));
        for (ListNode node: lists) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (!priorityQueue.isEmpty()){
            ListNode node = priorityQueue.poll();
            dummy.next = node;
            if (node.next != null){
                priorityQueue.offer(node.next);
            }
            dummy = dummy.next;
        }
        return res.next;
    }
}
