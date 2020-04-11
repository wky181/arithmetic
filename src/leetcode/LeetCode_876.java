package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/23 22:14
 * @Description:
 */
public class LeetCode_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast!=null && fast.next!=null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
