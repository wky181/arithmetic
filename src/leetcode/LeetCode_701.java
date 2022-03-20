package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/20 15:53
 * @Description:
 */
public class LeetCode_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
           return new TreeNode(val);
        }
        if (root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
