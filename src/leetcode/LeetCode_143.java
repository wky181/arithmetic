package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/17 10:26
 * @Description:
 */
public class LeetCode_143 {
    public static void main(String[] args) {
        int[] nums = {1};
        ListNode node = Utils.creatListNode(nums);
        new LeetCode_143().reorderList(node);
        Utils.printListNode(node);
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        //通过快慢指针快速找到中点
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        ListNode last = reverse(slow.next);

        slow.next = null;

        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (last!= null && head != null){
          ListNode lastNext = last.next;
          ListNode headNext = head.next;
          head.next = last;
          dummy.next = head;
          dummy = last;
          head = headNext;
          last = lastNext;
        }
        if (head != null ){
           dummy.next = head;
        }
        head = res.next;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
