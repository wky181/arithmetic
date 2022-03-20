package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/6/2 13:11
 * @Description:
 */
public class LeetCode_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return slow == fast;
    }
}
