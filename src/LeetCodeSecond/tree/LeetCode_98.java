package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/9/9 22:46
 * @Description:
 */
public class LeetCode_98 {
    public boolean isValidBST(TreeNode root) {
        return isValid(null, root, null);
    }
    public boolean isValid(TreeNode min, TreeNode node, TreeNode max){
        if (node == null){
            return true;
        }
        if (min != null && node.val < min.val){
            return false;
        }
        if (max != null && node.val > max.val){
            return false;
        }
        if (!isValid(min,node.left, node)){
            return false;
        }
        return isValid(node, node.right, max);
    }
    TreeNode pre = null;
    public boolean isValidBST1(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST1(root.left)){
            return false;
        }
        if (pre != null){
            if (root.val <= pre.val) {
                return false;
            }
        }
        pre = root;
        return isValidBST1(root.right);
    }
}
