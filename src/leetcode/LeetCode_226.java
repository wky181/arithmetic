package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/27 23:46
 * @Description:
 */
public class LeetCode_226 {
    public TreeNode invertTree(TreeNode root) {
        if ( root == null){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode rigth = invertTree(root.right);
        root.left = rigth;
        root.right = left;
        return root;
    }
}
