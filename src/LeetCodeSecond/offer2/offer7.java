package LeetCodeSecond.offer2;

import LeetCodeSecond.ListNode;
import LeetCodeSecond.tree.TreeNode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/9/9 23:52
 * @Description:
 */
public class offer7 {
    int cur;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> memo;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        memo = new HashMap<>();
        for (int i = 0; i < inorder.length ; i++) {
            memo.put(inorder[i], i);
        }
        return build(0,preorder.length - 1);
    }
    public TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }
        int num = preorder[cur];
        cur++;
        TreeNode node = new TreeNode(num);
        Integer orderIndex = memo.get(num);
        node.left = build(left, orderIndex-1);
        node.right = build(orderIndex+1, right);
        return node;
    }
}
