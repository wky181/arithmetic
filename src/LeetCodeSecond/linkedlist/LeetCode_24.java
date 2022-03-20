package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/7/30 21:03
 * @Description:
 */
public class LeetCode_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode node = swapPairs(next.next);
        head.next = node;
        next.next = head;
        return next;
    }
    // 迭代
    public ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null){
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return dummy.next;
    }
}
