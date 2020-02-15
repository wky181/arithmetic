package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/13 22:59
 * @Description:
 */
public class LeetCode_24 {
    /**
     * 迭代解法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //per是node1的前结点
        ListNode pre = dummyHead;
        while(pre.next != null && pre.next.next != null){
            //node1 和 node2是需要交换的结点
            ListNode node1 = pre.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            pre.next = node2;
            pre = node1;
        }
        dummyHead = dummyHead.next;
        return dummyHead;
    }
    /**
     * 递归解法
     * 其中我们应该关心的主要有三点：
     * 1、返回值 排序好的子链表的头结点
     * 2、调用单元做了什么 将要调换的两个结点 head 和 next 调换位置，并把 head.next指向子链表的头结点
     * 3、终止条件 当head.next == null 或者 head == null
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next =  head;
        return next;

    }
}
