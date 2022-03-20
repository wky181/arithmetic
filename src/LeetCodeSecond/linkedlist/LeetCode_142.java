package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/9/12 9:02
 * @Description:
 */
public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode node = isCycle(head);
        if (node == null){
            return null;
        }
        ListNode start = head;
        while (start != node){
            start = start.next;
            node = node.next;
        }
        return start;
    }
    public ListNode isCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return slow;
            }
        }
        return null;
    }
}
