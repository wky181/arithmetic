package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/1 13:02
 * @Description:
 */
public class LeetCode_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return method(root,false);
    }
    public int method (TreeNode root , boolean isLeft) {
        if (root == null){
            return 0;
        }else if (isLeft && root.left == null &&  root.right == null){
            return root.val + method(root.left, true) + method(root.right, false);
        }else {
            return method(root.left, true) + method(root.right, false);
        }
    }
}
