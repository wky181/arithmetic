package leetcode;

import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/2/16 22:52
 * @Description:
 */
public class LeetCode_61 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        ListNode node = Utils.creatListNode(nums);
        ListNode node1 = new LeetCode_61().rotateRight(node, 2);
        Utils.printListNode(node1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        int length = 0;
        ListNode cnt = head;
        while (cnt != null){
            length++;
            cnt = cnt.next;
        }
        k = k % length;
        if (k == 0){
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        int i = 0;
        for (; i < k - 1 && q.next != null; i++) {
            q = q.next;
        }
        if (i < k - 1 || head.next == null) {
            return head;
        } else {
            while (q.next != null) {
                pre = p;
                p = p.next;
                q = q.next;
            }
            if (p == head) {
                return p;
            }
            q.next = head;
            pre.next = null;
            return p;
        }

    }

    public ListNode reverse(ListNode head) {
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
