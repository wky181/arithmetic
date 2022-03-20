package LeetCodeSecond.offer2;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/9/15 23:57
 * @Description:
 */
public class offer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root  == null){
            return true;
        }
        return jundge(root.left, root.right);
    }
    public boolean jundge(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        return left.val == right.val && jundge(left.right, right.left) && jundge(left.right, right.left);
    }
}
