package leetcode;

import bluebridgecup_course.class_03.Util;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/2/9 23:35
 * @Description:
 */
public class LeetCode_83 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        Util.print(arr);
        ListNode head = Utils.creatListNode(arr);
        new LeetCode_83().deleteDuplicates(head);
        Utils.printListNode(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
       /* HashSet<Integer> hashSet = new HashSet<>();
        ListNode current = head;
        ListNode pre = head;
        while (current != null) {
           int value = current.val;
           if (hashSet.contains(value)){
               pre.next = current.next;
               //current.next = null;
               current = pre.next;
        }else {
               hashSet.add(value);
               pre = current;
               current = current.next;

           }
    }
        return head;*/
        ListNode current = head;
       /* ListNode pre = head;
        while (current != null) {
            if (pre.val == current.val) {
                pre.next = current.next;
                current = current.next;
            } else {
                pre = current;
                current = current.next;
            }
        }*/
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return head;
    }
}
