package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/9/12 0:11
 * @Description:
 */
public class LeectCode_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
