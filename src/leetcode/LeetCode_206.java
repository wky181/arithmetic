package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/8 22:12
 * @Description:
 */
public class LeetCode_206 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode listNode = creatListNode(nums);
        ListNode res = new LeetCode_206().reverseListN(listNode,2);
        Utils.printListNode(res);
    }
    //迭代法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null ;
        ListNode cur = head;
       // ListNode next  ;
        if (head == null || head.next == null){
            return head;
        }
        while (cur != null){
            //反转链表
            ListNode  next = cur.next;
           cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归法 对于递归算法，最重要的就是明确递归函数的定义
     * reverseList1(ListNode head) 就是将以head为起点的链表反转
     * 并返回反转之后的头结点
     * 参考：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
      * @param head
     * @return
     */

    public ListNode reverseList1(ListNode head){
        if (head.next == null){
            return head;
        }
        ListNode last = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    //用来存放后驱结点
    ListNode next = null;
    //扩展翻转链表的前n个结点
    public ListNode reverseListN(ListNode head,int n){
        if (n == 1){
            next = head.next;
            return head;
        }

        ListNode last = reverseListN(head.next,n-1);
        head.next.next = head;
        head.next = next;
        return last;
    }

    /**
     *  反转链表一部分
     *  给一个索引区间 [m,n]（索引从 1 开始），仅仅反转区间中的链表元素。
     *
     *
     */
   public ListNode reverseBetween(ListNode head, int m, int n){
       if (m==1){
         return reverseListN(head,n);
       }
       head.next = reverseBetween(head.next,m-1,n-1);
       return head;
   }
    public static ListNode creatListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        for (int i = 1; i < nums.length ; i++) {
            ListNode listNode =  new ListNode(nums[i]);
            tail.next = listNode;
            tail = listNode;
        }
        return head;
    }
}
