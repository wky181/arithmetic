package LeetCodeSecond.offer;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/6/19 15:03
 * @Description:
 */
public class LeetCode_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if ( k < 0){
            return null;
        }
        ListNode mark = head;
        for (int i = 1; i < k; i++) {
            if (mark == null){
                return null;
            }
            mark = mark.next;
        }
        while (mark.next != null){
            mark = mark.next;
            head = head.next;
        }
        return head;
    }
}
