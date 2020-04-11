package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/2/21 23:33
 * @Description:
 */
public class LeetCode_103 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = Utils.creatTree(nums);
        List<List<Integer>> lists = new LeetCode_103().zigzagLevelOrder(treeNode);
        System.out.println(lists);
    }
    //解题思路 正向遍历树的每一层，在输出的时候通过bool值控制正向还是逆向!
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        queue.offer(root);
        boolean isLeft = false;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode node =  queue.poll();
                   if (isLeft){
                       list.offerFirst(node.val);
                   }else {
                       list.add(node.val);
                   }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }

            }
            lists.add(list);
            isLeft = !isLeft;
        }
        return lists;
    }
}
