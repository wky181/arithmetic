package leetcode;
/**
 * @Author: wky233
 * @Date: 2019/12/9 21:21
 * @Description:
 */
public class LeetCode_2 {
    public static void main(String[] args) {
        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode res = new LeetCode_2().add(Utils.creatListNode(nums1),Utils.creatListNode(nums2));
        Utils.printListNode(res);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }else if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }
        ListNode first = new ListNode(0);
        ListNode res = first;
        int val1,val2,value,flag = 0;
        while (l1!=null || l2 !=null){
            val1 = l1 == null ? 0 : 1;
            val2 = l2 == null ? 0 : 1;
            value = val1 + val2 + flag;
            flag = value >= 10  ? 0 : 1;
            res.next = new ListNode(value);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return res;
    }
    public ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode currentHead = new ListNode(0);
        ListNode head = new ListNode(0);
        int flag = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            head.next = new ListNode((num1 + num2 + flag) % 10);
            flag = num1 + num2 + flag >= 10 ? 1 : 0;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            head = head.next;
        }
        if (flag == 1) {
            head.next = new ListNode(1);
        }
        return currentHead.next;
    }
    }
