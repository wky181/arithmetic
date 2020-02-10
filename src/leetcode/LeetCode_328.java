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
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even!= null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
