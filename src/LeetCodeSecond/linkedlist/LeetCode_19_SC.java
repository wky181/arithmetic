package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/7/29 23:44
 * @Description:
 */
public class LeetCode_19_SC {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode left = dummy;
        ListNode right = dummy;
        dummy.next = head;
        for (int i = 0; i < n+1 ; i++) {
            // dummy会走到 n+2 这
            if (right == null){
                return null;
            }
            right = right.next;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
