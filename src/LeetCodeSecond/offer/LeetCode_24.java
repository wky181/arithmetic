package LeetCodeSecond.offer;

import LeetCodeSecond.linkedlist.ListNode;

/**
 * @Author: wky233
 * @Date: 2020/6/19 20:00
 * @Description:
 */
public class LeetCode_24 {
    public ListNode reverseList1(ListNode head) {
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
    //递归
    // 函数意义返回翻转后的头结点
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = head.next;
        ListNode node = reverseList(head.next);
        last.next = head;
        head.next = null;
        return node;
    }
}
