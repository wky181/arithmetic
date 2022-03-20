package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/25 11:19
 * @Description:
 */
public class LeetCode_36 {
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        perOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void perOrder(Node root) {
        if(root != null){
            perOrder(root.left);
            if (pre == null){
                head = root;
            }else {
                pre.right = root;
            }
            root.left = pre;
            pre = root;
            perOrder(root.right);
        }
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }


    }

}
