package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/2/20 12:08
 * @Description:
 */
public class LeetCode_102 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        TreeNode treeNode = Utils.creatTree(nums);
        Utils.printTreenode(treeNode);
        List<List<Integer>> lists = new LeetCode_102().levelOrder(treeNode);
        System.out.println(lists);
    }
    public List<List<Integer>>  levelOrder(TreeNode root) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        if (root == null){
            return arrayList ;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root,0));
        while (!queue.isEmpty()){
            Node node = queue.poll();
            int level = node.levle;
            if (arrayList.size() == level ){
                arrayList.add(new ArrayList<>());
            }
            arrayList.get(level).add(node.node.val);
            if (node.node.left != null){
                queue.offer(new Node(node.node.left,level+1));
            }
            if (node.node.right != null){
                queue.offer(new Node(node.node.right,level+1));
            }
        }
        return arrayList;
    }

    class Node{
        public Node(TreeNode node, int levle) {
            this.node = node;
            this.levle = levle;
        }

        TreeNode node;
        int levle;
    }

}
