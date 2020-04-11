package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/3 14:46
 * @Description:
 */
public class LeetCode_235 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null){
            return null;
        }
        if (root == null){
            return null;
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
