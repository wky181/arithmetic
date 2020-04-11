package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/10 22:02
 * @Description:
 */
public class LeetCode_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer integer = 0;
        length(root,integer);
        return integer;
    }
    public int length(TreeNode root,Integer max) {
        if (root == null){
            return 0;
        }
        int left =  length(root.left,max);
        int right = length(root.right,max);
        max = Math.max(left + right,max);
        return Math.max(left,right)+1;
    }
}
