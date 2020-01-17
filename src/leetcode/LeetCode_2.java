package leetcode;



/**
 * @Author: wky233
 * @Date: 2019/12/9 21:21
 * @Description:
 */
public class LeetCode_2 {
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
}
