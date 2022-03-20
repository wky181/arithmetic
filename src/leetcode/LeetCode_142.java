package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/23 23:23
 * @Description:
 */
public class LeetCode_142 {
    public ListNode detectCycle(ListNode head) {
      ListNode res = isCycle(head);
      if (res == null){
          return null;
      }
      while (head != res){
          head = head.next;
          res = res.next;
      }
      return head;
    }
        public ListNode isCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null ){
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow){
                    return fast;
                }
            }
            return null;
        }

        public ListNode detectCycle1(ListNode head) {
            if (head == null){
                return null;
            }
            ListNode res = isCycle(head);
            if (res == null){
                return null;
            }
            ListNode start = head;
            while (start != res ){
                res = res.next;
                start = start.next;
            }
            return start;
        }
}
