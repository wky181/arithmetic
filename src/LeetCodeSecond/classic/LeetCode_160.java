package LeetCodeSecond.classic;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/9/19 22:48
 * @Description:
 */
public class LeetCode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = a.next == null ? headB : a.next;
            b = b.next == null ? headA : b.next;
        }
        return a;
    }
}
