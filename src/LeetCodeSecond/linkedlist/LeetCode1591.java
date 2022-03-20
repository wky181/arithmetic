package LeetCodeSecond.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wky233
 * @Date: 2020/6/26 22:17
 * @Description:
 */
public class LeetCode1591 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode dummy = head;
        ListNode pre = null;
        while (dummy != null){
            if (set.contains(dummy.val)){
                pre.next = dummy.next;
                dummy = pre.next;
            }else {
                pre = dummy;
                set.add(dummy.val);
                dummy = dummy.next;
            }
        }
        return head;
    }

    public ListNode sort(ListNode head) {
        ListNode per = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next != null){
            per = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (per == null){
            return slow;
        }else {
            per.next = null;
        }
        ListNode left = sort(head);
        ListNode right = sort(slow);
        // 合并两个有序子链表
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                dummy.next = left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left == null ? right : left;
        return res.next;
    }
}
