package LeetCodeSecond.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/19 10:22
 * @Description:
 */
public class LeetCode_1028 {
    public static void main(String[] args) {
        new LeetCode_1028().recoverFromPreorder("1-2--3--4-5--6--7");
    }
    public TreeNode recoverFromPreorder(String S) {
       return  buildTree(S,new StringBuilder());
    }
    public TreeNode buildTree(String s, StringBuilder depth){
        if (s.length() == 0){
            return null;
        }
        char c = s.charAt(0);
        TreeNode node = new TreeNode(c);
        depth.append('-');
        String spilt = depth.toString();
        int first = s.indexOf(spilt);
        int last = s.lastIndexOf(spilt);
        if (first == -1){
            return node;
        }
        else if (first == last){
            s = s.substring(first + depth.length());
            node.left = buildTree(s,depth);
        }
        else {
            System.out.println(s);
            System.out.println(first + " " + last);
            s = s.substring(first + depth.length(),last);
            node.left = buildTree(s,depth);
            s = s.substring(last + depth.length());
            node.right = buildTree(s,depth);
        }
        return node;
    }
    // 迭代 + 栈
    public TreeNode recoverFromPreorder1(String S) {
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < S.length() ; i++) {
            int level = 0;
            while (i < S.length() && S.charAt(i) == '-'){
                i++;
                level++;
            }
            int start = i;
            while (i <S.length() && S.charAt(i) != '-'){
                i++;
            }
            int end = i;

            String val = S.substring(start,end);
            Node node = new Node(new TreeNode(Integer.parseInt(val)),level);
            if (deque.isEmpty()){
                deque.addLast(node);
                continue;
            }
            // 如果栈顶节点深度大于等于当前节点, 需要弹出，说明以栈顶为底构成的子树已经完成
            while (deque.peekLast().level >= level){
                deque.pollLast();
            }
            TreeNode top = deque.peekLast().node;
            if (top.left == null){
                top.left = node.node;
            }else {
                top.right = node.node;
            }
            deque.addLast(node);
        }
        return deque.poll().node;
    }

    private class Node{
        TreeNode node;
        int level;
        public Node(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
