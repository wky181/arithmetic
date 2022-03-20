package LeetCodeSecond.offer2;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/9/15 23:54
 * @Description:
 */
public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
