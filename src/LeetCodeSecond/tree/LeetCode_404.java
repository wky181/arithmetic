package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/9/19 9:55
 * @Description:
 */
public class LeetCode_404 {
    int count = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root,true);
        return count;
    }

    public void dfs(TreeNode root, boolean isLeft){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            if (isLeft){
                count += root.val;
            }
            return;
        }
       TreeNode left =  root.left;
       TreeNode right = root.right;
       if (left != null){
           dfs(root.left,true);
       }
       if (right != null){
           dfs(root.right,false);
       }
    }
}
