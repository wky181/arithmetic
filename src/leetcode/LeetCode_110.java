package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/1 0:49
 * @Description:
 */
public class LeetCode_110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        int num = Math.abs(height(root.left) - height(root.right));
        if (num > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
