package swordoffer;

import LeetCodeSecond.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/8/27 9:04
 * @Description:
 */
public class Offer_6 {
    List<Integer> list;
    public int[] reversePrint(ListNode head) {
        list = new ArrayList<>();
        reverseAdd(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void reverseAdd(ListNode head){
        if (head == null){
            return;
        }
        reverseAdd(head.next);
        list.add(head.val);
    }
}
