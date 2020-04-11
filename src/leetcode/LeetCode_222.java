package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/1 0:02
 * @Description:
 */
public class LeetCode_222 {
    public static void main(String[] args) {

    }

    /**
     * 简单递归
     */
    int count = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return count = countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * 二分查找
     */
    public int countNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = level(root.left);
        int right = level(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        }else {
            return countNodes(root.left) + (1 << right);
        }
    }

    public int level(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
