package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/8 23:39
 * @Description:
 */
public class LeetCode_92 {
    //用来存放后驱结点
    ListNode next = null;
    //扩展翻转链表的前n个结点
    public ListNode reverseListN(ListNode head,int n){
        if (n == 1){
            next = head.next;
            return head;
        }

        ListNode last = reverseListN(head.next,n-1);
        head.next.next = head;
        head.next = next;
        return last;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1){
          return reverseListN(head,n);
        }
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
}
