package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/6/2 14:29
 * @Description:
 */
public class LeetCdoe_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0 || head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode left = dummyHead;
        ListNode right = dummyHead;

        for (int i = 0; i < n + 1 ; i++) {
            right = right.next;
        }
        while (right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummyHead.next;
    }
}
