package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/16 11:51
 * @Description:
 */
public class LeetCode_19 {
    public static void main(String[] args) {
       /* int[] nums = {1};
        ListNode node = Utils.creatListNode(nums);
       Utils.printListNode( new LeetCode_19().removeNthFromEnd1(node, 100));*/
        System.out.println();
    }
    /**
     * 两次遍历找到删除结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        ListNode dummyHead = new ListNode(0);
        ListNode res = dummyHead;
        dummyHead.next = head;
        while (head != null) {
            head = head.next;
            length++;
        }
        if (n > length || length <= 0 || n <= 0){
            return node;
        }
        int k = (length - n);
        ListNode pre = null;
        for (int i = 0; i < k+1 && dummyHead != null; i++) {
            pre = dummyHead;
            dummyHead = dummyHead.next;
        }
        ListNode next = dummyHead.next;
        pre.next = next;
        return res.next;
    }

    /**
     * 利用双指针，一次遍历删除结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (n <= 0){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        int i = 0;
        for (; i < n+1 && q != null ; i++) {
            q = q.next;
        }
        while (q != null){
            p = p.next;
            q = q.next;
        }
        ListNode deleteNode = p.next;
        p.next = deleteNode.next;
        return dummyHead.next;
    }

}
