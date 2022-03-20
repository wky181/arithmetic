package LeetCodeSecond.offer;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/6/18 10:42
 * @Description:
 */
public class LeetCode_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode res = dummy;
        while (dummy.next != null){
            if (dummy.next.val == val){
                dummy.next = dummy.next.next;
                break;
            }
            dummy = dummy.next;
        }
        return res.next;
    }
}
