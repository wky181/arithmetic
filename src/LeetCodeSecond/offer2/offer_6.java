package LeetCodeSecond.offer2;

import LeetCodeSecond.linkedlist.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/9/9 23:45
 * @Description:
 */
public class offer_6 {
    List<Integer> list;
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length ; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
