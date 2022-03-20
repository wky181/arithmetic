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
        ListNode res = new LeetCode_148().sortList1(listNode);
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


    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode per = slow;
        while (fast != null && fast.next != null){
            per = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 将链表从中间切成两段
        per.next = null;
        ListNode left = sortList1(head);
        ListNode right = sortList1(slow);
        // 合并链表返回合并后的头结点
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (left!= null && right != null){
            if (left.val < right.val){
                dummy.next = left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        dummy.next = left == null ? right : left;
        return res.next;
    }

}
