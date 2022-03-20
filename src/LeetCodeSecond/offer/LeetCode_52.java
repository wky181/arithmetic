package LeetCodeSecond.offer;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/6/30 0:21
 * @Description: 双指针 时间复杂度o(m + n)
 */
public class LeetCode_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2){
          node1 = node1 == null ? headB : node1.next;
          node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }
}
