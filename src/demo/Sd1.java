package demo;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/9/26 10:39
 * @Description:
 */
public class Sd1 {
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode first = dummy;
        dummy.next = head;
        for (int i = 0; i < n + 1; i++) {
            dummy = dummy.next;
            if (dummy == null){
                return head.next;
            }
        }
        ListNode pre = null;
        while (dummy != null) {
            first = first.next;
            pre = first;
            dummy = dummy.next;
        }
        if (pre == null || pre.next == null) {
            return head;
        } else {
            pre.next = pre.next.next;
        }
        return head.next;
    }
}
