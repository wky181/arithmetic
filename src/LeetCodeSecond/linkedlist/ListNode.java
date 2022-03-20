package LeetCodeSecond.linkedlist;

/**
 * @Author: wky233
 * @Date: 2020/6/2 10:28
 * @Description:
 */
public class ListNode implements Comparable<ListNode> {
   public int val;
  public ListNode next;
   public ListNode(int x) { val = x; }

    @Override
    public int compareTo(ListNode another) {
        return this.val - another.val;
    }
}
