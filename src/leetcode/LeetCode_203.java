package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/12 22:51
 * @Description:
 */
public class LeetCode_203 {
    public static void main(String[] args) {
        int[] nums  = {1,2,3,4,4,5,1,6};
        ListNode listNode = Utils.creatListNode(nums);
        ListNode res = new  LeetCode_203().removeElements(listNode,1);
        Utils.printListNode(res);
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode virtualHead  = new ListNode(0);
        ListNode res = virtualHead;
        virtualHead.next = head;
        while (virtualHead.next != null){
           int value = virtualHead.next.val;
           if (value == val){
               virtualHead.next = virtualHead.next.next;
           }else {
               virtualHead = virtualHead.next;
           }
        }
        res =res.next;
        return res;
    }
}
