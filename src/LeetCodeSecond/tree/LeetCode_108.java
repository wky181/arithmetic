package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/7/3 16:40
 * @Description:
 */
public class LeetCode_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return bulidBST(nums, 0, nums.length);
    }
    public TreeNode bulidBST(int[] nums, int left, int right) {
         if (left > right){
             return null;
         }
         int mid = left + (right - left) / 2;
         TreeNode root = new TreeNode(nums[mid]);
         root.left = bulidBST(nums, left, mid-1);
         root.right = bulidBST(nums, mid+1, right);
         return root;
    }
}
