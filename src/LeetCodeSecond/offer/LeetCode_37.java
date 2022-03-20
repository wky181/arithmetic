package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/6/25 21:48
 * @Description:
 */
public class LeetCode_37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node != null){
                sb.append(node.val);
                deque.offer(node.left);
                deque.offer(node.right);
            }else {
                sb.append("null");
            }
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
        String[] vals = data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Deque<TreeNode> deque = new  LinkedList<>();
        deque.offer(root);
        int i = 1;
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                deque.offer(node.left);
            }
            i++;
            if (!vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                deque.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
