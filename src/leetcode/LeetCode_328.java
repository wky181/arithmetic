package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/10 22:06
 * @Description:
 */
public class LeetCode_328 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode listNode = Utils.creatListNode(nums);
        ListNode res = new LeetCode_328().oddEvenList(listNode);
        Utils.printListNode(res);
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode oddLast = head;
        ListNode even = head.next;
        ListNode evenLast = head.next;
        while (evenLast != null && evenLast.next!=null  ){
              oddLast.next = evenLast.next;
              oddLast = oddLast.next;
              evenLast.next = oddLast.next;
              evenLast = evenLast.next;
        }
        oddLast.next = even;
        return head;

    }

}
