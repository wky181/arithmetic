package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/27 22:59
 * @Description:
 */
public class LeetCode_104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
