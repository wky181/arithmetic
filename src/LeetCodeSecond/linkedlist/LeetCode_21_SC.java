package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/7/30 17:40
 * @Description:
 */
public class LeetCode_21_SC {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (l1 != null && l2 != null){
             if (l1.val < l2.val){
                 dummy.next = l1;
                 l1 = l1.next;
             }else {
                 dummy.next = l2;
                 l2 = l2.next;
             }
             dummy = dummy.next;
        }
        dummy.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
