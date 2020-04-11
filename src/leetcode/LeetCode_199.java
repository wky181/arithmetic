package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/2/22 0:00
 * @Description:
 */
public class LeetCode_199 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = Utils.creatTree(nums);
        System.out.println(new LeetCode_199().rightSideView(treeNode));
    }
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root == null){
            return null;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            res.add(queue.peek().val);
            int size = queue.size();
            TreeNode treeNode;
            for (int i = 0; i < size ; i++) {
                treeNode = queue.poll();
                if (treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null){
                    queue.offer(treeNode.left);
                }

            }
        }

        return res;
    }

}
