package LeetCodeSecond.offer;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/7/29 23:28
 * @Description:
 */
public class LeetCode_24_sc {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    // 递归 函数定义为返回head的开头的链表，并返回翻转后的头
    public ListNode reverseList1(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode last = head.next;
        ListNode node = reverseList1(head.next);
        head.next = null;
        last.next = head;
        return node;
    }
}
