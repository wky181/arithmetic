package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/6/19 20:36
 * @Description:
 */
public class LeetCode_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }
        else if (left == null || right == null){
            return false;
        }
        boolean first = left.val == right.val;
        return first && isSymmetric(left.left, right.right) && isSymmetric(left.right,right.left);
    }
}
