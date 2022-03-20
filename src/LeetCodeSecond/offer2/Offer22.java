package LeetCodeSecond.offer2;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/9/9 23:30
 * @Description:
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode mark = dummy;
        for (int i = 0; i < k+1 ; i++) {
            if (mark == null){
                return null;
            }
            mark = mark.next;
        }
        while (mark != null){
            mark = mark.next;
            dummy = dummy.next;
        }
        return dummy.next;
    }
}
