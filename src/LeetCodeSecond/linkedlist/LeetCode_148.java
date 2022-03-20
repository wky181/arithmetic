package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/9/12 10:34
 * @Description:
 */
public class LeetCode_148 {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }
    public ListNode sort(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表
        pre.next = null;
        ListNode left = sort(head);
        ListNode right = sort(slow);
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                dummy.next = left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left == null ? right : left;
        return res.next;
    }
}
