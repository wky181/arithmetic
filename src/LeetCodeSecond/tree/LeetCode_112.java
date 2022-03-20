package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/7/7 21:00
 * @Description:
 */
public class LeetCode_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
       return findSum(root,0,sum);
    }
    public boolean findSum(TreeNode root,int target, int sum) {
        if (root == null){
            return false;
        }
        target += root.val;
        if (target == sum && root.left == null && root.right == null){
            return true;
        }
        return findSum(root.left, target, sum)|| findSum(root.right, target, sum);
    }
}
