package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/6/2 10:28
 * @Description:
 */
public class LeetCode_206 {
    // 迭代 三个指针 前一个 当前 下一个
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
    /**
     * 函数意义 返回以head为头节点的链表翻转后的头结点
      */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList1(head.next);
        //此时 head.next是翻转后的末尾结点
        head.next.next = head;
        head.next = null;
        return last;
    }
}
