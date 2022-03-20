package LeetCodeSecond.offer2;

import LeetCodeSecond.tree.TreeNode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/9/16 10:29
 * @Description:
 */
public class offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null){
            return listList;
        }
        deque.offer(root);
        boolean nixu = false;
        while (!deque.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int size = deque.size();
            while (size > 0){
                TreeNode node = deque.poll();
                if (nixu){
                    list.offerFirst(node.val);
                }else {
                    list.offer(node.val);
                }
                if (node.left != null){
                    deque.offer(node.left);
                }
                if (node.right != null){
                    deque.offer(node.right);
                }
                nixu = !nixu;
                size--;
            }
            listList.add(list);
        }
        return listList;
    }
}
