package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/23 22:57
 * @Description:
 */
public class LeetCode_141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
