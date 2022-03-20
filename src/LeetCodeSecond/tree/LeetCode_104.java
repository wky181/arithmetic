package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/7/28 15:02
 * @Description:
 */
public class LeetCode_104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
