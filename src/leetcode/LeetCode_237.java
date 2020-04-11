package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/16 11:09
 * @Description:
 */
public class LeetCode_237 {
    public static void main(String[] args) {

    }

    /**
     * 将下一个结点的值赋值给当前要删除的结点，删除下一个结点
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null){
            node = null;
        }else {
            ListNode deleteNode = node.next;
            node.val = deleteNode.val;
            ListNode next = deleteNode.next;
            node.next = next;
        }
    }
}
