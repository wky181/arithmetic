package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/7/30 23:16
 * @Description:
 */
public class LeetCode_25 {
    // 递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode end = head;
        for (int i = 0; i < k ; i++) {
            if (end == null){
                return head;
            }
            end = end.next;
        }
        ListNode start = reverseK(head, end);
        ListNode node = reverseKGroup(end, k);
        head.next = node;
        return start;
    }
    public ListNode reverseK(ListNode head, ListNode end) {
        ListNode pre = null;
        while (head != end){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    // 迭代
    public ListNode reverseKGroup1(ListNode head, int k) {
       // ListNode dummy = new ListNode()
        return null;
    }
}
