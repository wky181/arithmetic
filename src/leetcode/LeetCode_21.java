package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/13 12:23
 * @Description:
 */
public class LeetCode_21 {
    public static void main(String[] args) {
        int[] nums  = {1,1,2,6,7};
        int[] nums1  = {1,1,5,7,9};

        ListNode listNode = Utils.creatListNode(nums);
        ListNode listNode1 = Utils.creatListNode(nums1);
        ListNode res = new  LeetCode_21().mergeTwoLists(listNode,listNode1);
        Utils.printListNode(res);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null &&  l2 == null){
            return null;
        }
        else if (l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;
        }
       ListNode listNode = new ListNode(0);
        ListNode res = listNode;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                listNode.next = l2;
                l2 = l2.next;
            }else {
                listNode.next = l1;
                l1 = l1.next;
            }
            listNode = listNode.next;
        }

       /* if (l1 == null){
            while (l2 != null ){
                listNode.next = l2;
                listNode = listNode.next;
                l2 = l2.next;
            }
        }
        else {
            while (l1 != null){
                listNode.next = l1;
                listNode = listNode.next;
                l1 = l1.next;
            }
        }*/
       //由于是链表优化此部分代码
        listNode.next = l1 == null ? l2 : l1;
        res = res.next;
        return res;
    }
}