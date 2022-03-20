package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/20 13:54
 * @Description:
 */
public class LeetCode_124 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        slove(root);
        return res;
    }
    public int slove(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int right = slove(root.right);
        int left = slove(root.left);
        //以当且结点为最终路径 与全局变量比较得出最优解
        res = Math.max(res, right + left + val);
        //不以当前结点作为终点，选择最大子节点 + val 表示该结点作为子树的最大和
        return Math.max(0, Math.max(left, right) + val);
    }
}
