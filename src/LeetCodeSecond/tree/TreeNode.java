package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/6/5 14:26
 * @Description:
 */
public class TreeNode {
   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode(int x) { val = x; }
   TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
