package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/12 23:08
 * @Description:
 */
public class LeetCode_82 {
    public static void main(String[] args) {
        int[] nums  = {1,1};
        ListNode listNode = Utils.creatListNode(nums);
        ListNode res = new  LeetCode_82().deleteDuplicates(listNode);
        Utils.printListNode(res);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        // 设置虚拟头结点,防止头结点也是重复元素时，删除不好处理。
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode res = virtual;
        while (virtual.next != null){
            int val = virtual.next.val;
            // 判断virtual.next这个结点是否存在重复值，如果有，就全部遍历出来
           if (virtual.next.next != null && virtual.next.next.val == val){
               ListNode temp = virtual.next.next;
               //temp最终指向与val不同的下一个结点或者null
               while (temp != null && temp.val == val ){
                   temp = temp.next;
               }
               virtual.next = temp;
           }else {
               virtual = virtual.next;
           }
        }
        //删除虚拟头结点,返回结果
        return res = res.next;
    }
}
