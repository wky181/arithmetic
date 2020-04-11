package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/6 13:07
 * @Description:
 */
public class LeetCode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return nums == null ? null : helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int index = l + (r - l)/2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, l, index - 1);
        node.right = helper(nums, index + 1, r);
        return node;
    }
}
