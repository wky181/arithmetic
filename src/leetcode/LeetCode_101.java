package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/28 1:03
 * @Description:
 */
public class LeetCode_101 {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null ){
            return true;
        }
        return methed(root.left,root.right);
    }
    public boolean methed(TreeNode left, TreeNode right) {
        if (left == null && right == null){
            return true;
        }else if (left == null || right == null){
            return false;
        }
        return left.val == right.val && methed(left.right, right.left) && methed(left.left , right.right);

    }
}
