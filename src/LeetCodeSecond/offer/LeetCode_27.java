package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/6/19 20:19
 * @Description:
 */
public class LeetCode_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right =  mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
