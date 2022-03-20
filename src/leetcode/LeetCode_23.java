package leetcode;

import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/2/26 22:55
 * @Description:
 */
public class LeetCode_23 {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};
        ListNode node1 = Utils.creatListNode(nums1);
        ListNode node2 = Utils.creatListNode(nums2);
        ListNode node3 = Utils.creatListNode(nums3);
        ListNode[] listNodes = {node1, node2, node3};
        ListNode res = new LeetCode_23().mergeKLists1(listNodes);
        Utils.printListNode(res);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null && node.next != null) {
                dummy.next = node;
                dummy = dummy.next;
                node = node.next;
            }
            dummy.next = node;
            if (node != null) {
                dummy = dummy.next;
            }
        }
        ListNode result = sortList(res.next);
        return result;

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (left != null && right != null) {
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            } else {
                node.next = left;
                left = left.next;
            }
            node = node.next;
        }
        node.next = left == null ? right : left;
        return res.next;

    }

    /**
     * 利用java优先级队列来写
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        if (lists == null || lists.length == 0){
            return res.next;
        }
        PriorityQueue<ListNode> minheap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode listNode : lists) {
            if (listNode != null){
                minheap.offer(listNode);
            }
        }
        while (!minheap.isEmpty()){
            ListNode listNode = minheap.poll();
            res.next = listNode;
            res = res.next;
            if (listNode.next != null){
                minheap.offer(listNode.next);
            }
        }
        dummy = dummy.next;
        return dummy;
    }

}
