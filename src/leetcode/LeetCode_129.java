package leetcode;

import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/3/3 0:16
 * @Description:
 */
public class LeetCode_129 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        TreeNode treeNode = Utils.creatTree(nums);
        int i = new LeetCode_129().sumNumbers(treeNode);
        System.out.println(i);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int nums) {
        if (root == null) {
            return 0;
        }
        nums = nums * 10 + root.val  ;
        if (root.left == null && root.right == null) {
            return nums ;
        }
        int left = sumNumbers(root.left, nums);
        int right = sumNumbers(root.right, nums);
        return left + right;
    }
}
