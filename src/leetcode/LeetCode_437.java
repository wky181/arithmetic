package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/3 14:05
 * @Description:
 */
public class LeetCode_437 {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        int path = findPath(root, sum);
        return path + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    public int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}
