package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/7 0:25
 * @Description:
 */
public class LeetCode_236 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root== null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;

    }
}
