package leetcode;

/**
 * @author 武凯焱
 * @date 2019/7/31 17:01
 * @Description:
 */
public class 两数相加 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return plusAB(l1,l2,0);
    }
    public static ListNode plusAB(ListNode a, ListNode b, int i) {
        if (a == null && b == null && i == 0) {
            return null;
        }
        int value = 0;
        value += i;
        if (a != null) {
            value += a.val;
            a = a.next;
        }
        if (b != null) {
            value += b.val;
            b = b.next;
        }
        i = value >= 10 ? 1 : 0;
        value = value%10;
        ListNode result = new ListNode(value);
        result.next = plusAB(a, b, i);
        return result;
    }
}
