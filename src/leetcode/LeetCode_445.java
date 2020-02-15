package leetcode;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/11 23:33
 * @Description:
 */
public class LeetCode_445 {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 3};
      /*  LeetCode_443 leet =  new LeetCode_443();
        ListNode res = leet.revese(Utils.creatListNode(nums1));
        Utils.printListNode(res);*/
        int[] nums2 = {5, 6, 4};
        ListNode res = new LeetCode_445().addTwoNumbers(Utils.creatListNode(nums1), Utils.creatListNode(nums2));
        Utils.printListNode(res);
    }

    //
    public ListNode revese(ListNode head) {
        ListNode per = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null && current.next != null) {
            next = current.next;
            current.next = per;
            per = current;
            current = next;
        }
        current.next = per;
        return current;
    }

    /**
     * 通过反转链表来做
     */
    public ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        l1 = revese(l1);
        l2 = revese(l2);
        ListNode node = new ListNode(0);
        ListNode res = node;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int value = num1 + num2 + flag;
            flag = value >= 10 ? 1 : 0;
            node.next = new ListNode(value % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            node = node.next;
        }
        if (flag == 1) {
            node.next = new ListNode(1);
        }
        res = revese(res.next);
        return res;
    }

    /**
     * 利用双栈来做，不用反转链表了
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
        return null;
    } else if (l1 == null) {
        return l2;
    } else if (l2 == null) {
        return l1;
    }
        Stack<Integer> stackl1 = new Stack<>();
        Stack<Integer> stackl2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                stackl1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null){
                stackl2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode listNode =  new ListNode(0);
        ListNode tail = null;
        int flag = 0;
        while (!stackl1.isEmpty() || !stackl2.isEmpty()) {
            int numl1 = stackl1.isEmpty() ? 0 : stackl1.pop();
            int numl2 = stackl2.isEmpty() ? 0 : stackl2.pop();
            int value = numl1 + numl2 + flag;
            flag = value >= 10 ? 1 : 0;
            ListNode temp = new ListNode(value % 10);
            temp.next = tail;
            tail = temp;
        }
        if (flag == 1){
            ListNode temp = new ListNode(1);
            temp.next = tail;
            tail = temp;
        }
        return tail;
    }
}
