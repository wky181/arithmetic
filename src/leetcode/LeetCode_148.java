package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/14 22:24
 * @Description:
 */
public class LeetCode_148 {
    public static void main(String[] args) {
        int[] nums  = {4,1,6,5,4};
        ListNode listNode = Utils.creatListNode(nums);
        ListNode res = new LeetCode_148().sortList(listNode);
        Utils.printListNode(res);
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = slow.next;
        slow.next = null;
        ListNode node = new ListNode(-1);
        ListNode res = node;
        ListNode left = sortList(head);
        ListNode right = sortList(tail);
        while (left!= null && right != null){
            if (left.val < right.val){
                res.next = left;
                left = left.next;
            }else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = left == null ? right : left;
        node = node.next;
        return node;
    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        return null;
    }

}
