package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/6/30 16:03
 * @Description:
 */
public class LeetCode_55_2 {
    // 先序遍历 + 深度判断
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return (right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        return node == null ? 0 : 1 + Math.max(depth(node.left), depth(node.right));
    }

    // 后序遍历 + 剪枝
    public boolean isBalanced1(TreeNode root) {
        int recur = recur(root);
        return recur != -1;
    }

    // 返回当前树的深度
    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(right - left) < 2 ? Math.max(right,left) + 1 : -1;
    }
}
