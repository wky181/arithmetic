package LeetCodeSecond.offer2;

import LeetCodeSecond.offer.Node;

/**
 * @Author: wky233
 * @Date: 2020/9/16 16:11
 * @Description:
 */


public class offer36 {
    Node pre , head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void dfs(Node cur){
        if (cur != null){
            dfs(cur.left);
            if (pre == null){
                head = cur;
            }else {
                pre.right = cur;
            }
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }
    }
   private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
