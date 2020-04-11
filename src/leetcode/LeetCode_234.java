package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/17 12:03
 * @Description:
 */
public class LeetCode_234 {
    public static void main(String[] args) {
        int[] nums = {1, 1};
        ListNode node = Utils.creatListNode(nums);
        boolean res = new LeetCode_234().isPalindrome(node);
        System.out.println(res);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode last = revers(slow.next);
        slow.next = null;
        while (last != null) {
            if (head.val != last.val) {
                return false;
            }
            head = head.next;
            last = last.next;
        }
        return true;
    }

    public ListNode revers(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
