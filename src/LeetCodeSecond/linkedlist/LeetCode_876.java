package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/6/2 15:05
 * @Description:
 */
public class LeetCode_876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
