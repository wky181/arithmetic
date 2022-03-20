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

    /**
     * 递归函数意义：判断以root为根节点的树是否是二叉搜索树
     * @param top root 结点的上限节点，要小于上限节点
     * @param end root 结点的下限节点，要大于下限节点
     * @param root
     * @return
     */
    public boolean isValid(TreeNode top, TreeNode end,TreeNode root) {
        if (root == null){
            return true;
        }
        if (top != null && root.val >= top.val){
            return false;
        }
        if (end != null && root.val <= end.val){
            return false;
        }
        // 查看左子树是否是二叉搜索树
        boolean left = isValid(root,end,root.left);
        // 查看右子树是否是二叉搜索树
        boolean right = isValid(top,root,root.right);
        return left && right;
    }
}
