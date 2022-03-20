package LeetCodeSecond.linkedlist;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/8/2 17:54
 * @Description:
 */
public class LeetCdoe_114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root = pre;
        root.left = null;
    }
}
