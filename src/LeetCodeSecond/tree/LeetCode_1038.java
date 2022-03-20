package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/7/18 21:07
 * @Description:
 */
public class LeetCode_1038 {
    public TreeNode bstToGst(TreeNode root) {
        bst(root);
        return root;
    }
    int num = 0;
    public void bst(TreeNode root) {
        if (root != null){
            bst(root.right);
            root.val += num;
            num = root.val;
            bst(root.left);
        }
    }
}
