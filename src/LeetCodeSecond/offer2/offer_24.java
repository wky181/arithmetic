package LeetCodeSecond.offer2;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/9/15 22:30
 * @Description:
 */
public class offer_24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next =  head.next;
        ListNode last = reverseList(head.next);
        next.next = head;
        head.next = null;
        return last;
    }
}
