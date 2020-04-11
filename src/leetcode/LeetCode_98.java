package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/4 0:52
 * @Description:
 */
public class LeetCode_98 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return root.right.val > root.val && isValidBST(root.right);
        } else if (root.right == null) {
            return root.left.val < root.val && isValidBST(root.left);
        }
        boolean isTrue = root.left.val < root.val && root.right.val > root.val;
        return isTrue && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root, TreeNode lower, TreeNode upper) {
        if (root == null){
            return true;
        }
        int val = root.val;
        if (lower != null && lower.val >= val ){
            return false;
        }
        if (upper != null && upper.val <= val ){
            return false;
        }
        return helper(root.left, lower , root.right) && helper(root.right, root , upper);
    }
}
