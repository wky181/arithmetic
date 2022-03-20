package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/9/21 18:12
 * @Description:
 */
public class LeetCode_538 {
    public TreeNode convertBST(TreeNode root) {
        order(root);
        return root;
    }
    int sum = 0;
    public void order(TreeNode root) {
        if (root != null){
           order(root.right);
           root.val += sum;
           sum = root.val;
           order(root.left);
        }
    }
}
