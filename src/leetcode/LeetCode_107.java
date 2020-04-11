package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/2/20 23:15
 * @Description:
 */
public class LeetCode_107 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        TreeNode treeNode = Utils.creatTree(nums);
        Utils.printTreenode(treeNode);
        List<List<Integer>> lists = new LeetCode_107().levelOrderBottom(treeNode);
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode node =  queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            lists.offerFirst(list);
        }
        return lists;
    }
}
