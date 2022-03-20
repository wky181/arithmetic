package LeetCodeSecond.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/6/16 21:41
 * @Description:
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Deque<TreeNode> path = new LinkedList<>();
        path.offer(root);
        while (!path.isEmpty()){
            TreeNode node = path.poll();
            if (node == null){
                sb.append("null,");
            }else {
                sb.append(node.val + ",");
                path.offer(node.left);
                path.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null|| data.equals("")){
            return null;
        }
        data =  data.substring(1,data.length()-1);
        String[] arrays = data.split(",");
        TreeNode node = new TreeNode(Integer.parseInt(arrays[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(node);
        int index = 1;
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.poll();
            String s = arrays[index++];
            if (!s.equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(s));
                deque.offer(left);
                treeNode.left = left;
            }
            s = arrays[index++];
            if (!s.equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(s));
                deque.offer(right);
                treeNode.right = right;
            }
        }
        return node;
    }
  /*  public TreeNode buildTree(String[] arrays, int index){
        if (index >= arrays.length){
            return null;
        }
        String s = arrays[index];
        if(s.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arrays[index]));
        node.left = buildTree(arrays, index * 2 + 1);
        node.right = buildTree(arrays, index * 2 + 2);
        return node;
    }*/

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("[5,2,3,null,null,2,4,3,1]");
      //  System.out.println(deserialize.val);
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);
    }
}
