package leetcode;

/**
 * @author 武凯焱
 * @date 2019/11/2 15:18
 * @Description:
 */

public class Leetcode_112 {
    static boolean mark = false;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
    }
    public static boolean hasPathSum(TreeNode root, int sum) {

        method(root, 0,sum);
        return mark;
    }

    public static void method(TreeNode treeNode, int sum, int target) {
        sum += treeNode.val;
        if (treeNode.right == null && treeNode.left == null && target == sum) {
            mark =  true;
            return;
        }
        if (treeNode.left != null) {
            method(treeNode.left, sum, target);
        }
        if (treeNode.right != null) {
            method(treeNode.right, sum, target);
        }
    }
}
