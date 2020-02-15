package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/13 23:17
 * @Description:
 */
public class LeetCode_25 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        ListNode listNode = Utils.creatListNode(nums);
        ListNode res = new LeetCode_25().reverseKGroup1(listNode,2);
        Utils.printListNode(res);
    }

    /**
     * 1、返回值 就是每组翻转后子链表的头节点
     * 2、调用单元操作 检查是否足够k个结点，如果够进行一组翻转。
     * 3、终止条件 不足k个结点
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null ) {
                return head;
            }
            ListNode node = head ;
            //先检查是否够k个，不够直接return
            for (int i = 0; i < k ; i++) {
                if (head == null){
                    return node;
                }
                head = head.next;
            }
            // 够k个后进行翻转
            ListNode first = reverse(node,head);
            // 翻转后 node结点为尾结点， node.next 指向下一组的头结点
            node.next = reverseKGroup(head,k);

            return first;

        }
        ListNode next = null;
        public ListNode reverseK(ListNode head,int k){
            if (head == null){
                return null;
            }
            if (head.next == null || k == 1){
               next = head.next;
               return head;
            }
            ListNode last = reverseK(head.next,k-1);
            head.next.next = head;
            head.next = next;
            return last;
    }
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode next ;
        ListNode pre = null;
        while (head != tail){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 使用迭代法来做
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        // 把上一个翻转过的子链表的尾指向下一个翻转过的子链表的头
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        ListNode tail = head;
        while (tail != null) {
            //查看是否满足k个
            int i = 0;
            for (; i < k && tail!= null; i++) {

                tail = tail.next;
            }
            // 判断是否是k个
            if (i < k) {
                temp.next = head;
                break;
            } else {
                ListNode nextHead = tail;
                ListNode first = reverse(head, tail);
                temp.next = first;
                temp = head;
                //下一個长度为k的子链表的头结点
                head = nextHead;
            }
        }
        return res.next;
    }


}
