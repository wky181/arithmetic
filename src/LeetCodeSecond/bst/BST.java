package LeetCodeSecond.bst;

import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/6/8 15:21
 * @Description:
 */
public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }
    private class Node {
       public E e;
       public Node left, right;
       public Node(E e) {
           this.e = e;
           left = null;
           right = null;
       }
   }
   public int size(){
        return size;
   }
   public boolean isEmpty(){
        return size == 0;
   }
   // 向以node为根的二叉搜索树插入新元素
  public void add(E e){
           root = add(root,e);
   }
    // 向以node为根的二叉搜索树插入新元素, 并返回插入新节点后的根元素
    private Node add(Node root, E e) {
        if (root == null){
            size++;
            return new Node(e);
        }
        else if (root.e.compareTo(e) > 0){
            root.left = add(root.left,e);
        }
        else if (root.e.compareTo(e) < 0){
            root.right = add(root.right, e);
        }
        return root;
    }
    // 看看二分搜索树是否包含元素e
    public boolean contains(Node node){
        return contains(node);
    }
    // 看以node为根的二分搜索树是够包含元素e,递归算法
    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }
        else if (node.e.compareTo(e) > 0){
            return contains(node.left);
        }
        else {
            return contains(node.right);
        }
    }
    // 先序
    private void preOrder(Node node){
        if (node != null){
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void preOrder(){
        preOrder(root);
    }
    // 非递归先序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (pop.right != null){
                stack.push(pop.right);
            }
            if (pop.left != null){
                stack.push(pop.left);
            }
        }
    }
    // 非递归中序遍历
    // 中序
    public  void inOrderNR(){
        Stack<Node> stack = new Stack<>();
        Node root = this.root;
        while (!stack.isEmpty() || root!= null){
            // 当前根元素不为空遍历左子树
            if (root != null){
                stack.push(root);
                root = root.left;
            }
            // 先打印根元素再遍历右子树
            else {
               // System.out.println(stack.empty());
                Node temp = stack.pop();
                System.out.println(temp.e);
                root = temp.right;
            }
        }
    }
    // 非递归中序遍历
    // 中序
    public  void inOrderNRPlus(){
        Stack<Command> stack = new Stack<>();
        Node root = this.root;
        if (root == null){
            return;
        }
        Command command = new Command(root,true);
        stack.push(command);
        while (!stack.isEmpty()){
            Command pop = stack.pop();
            if (!pop.isGo){
                System.out.println(pop.node.e);
            }else {
                // 后序遍历在这添加后打印
                // stack.push(new Command(pop.node, false));
                if (pop.node.right != null) {
                    stack.push(new Command(pop.node.right, true));
                }
                // 中序遍历在这添加中打印
                stack.push(new Command(pop.node, false));
                if (pop.node.left != null) {
                    stack.push(new Command(pop.node.left, true));
                }
                // 先序遍历在这添加先打印
                //stack.push(new Command(pop.node, false));
            }
        }
    }
    private class Command{
        Node node;
        boolean isGo;

        public Command(Node node, boolean isGO) {
            this.node = node;
            this.isGo = isGO;
        }
    }
    private void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.println(node.e);
            inOrder(node.right);
        }
    }
    public void inOrder(){
        inOrder(root);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        generateBSTString(root,0,builder);
        return builder.toString();
}
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);

    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth ; i++) {
            res.append("--");

        }
        return res.toString();
    }

    public E mininum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return mininum(root).e;
    }

    private Node mininum(Node root) {
        if (root.left == null){
            return root;
        }
        return mininum(root.left);
    }

    public E maxnum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        return maxnum(root).e;
    }
    private Node maxnum(Node root) {
        if (root.right == null){
            return root;
        }
        return maxnum(root.right);
    }
    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E ret = mininum();
        root = removeMin(root);
        return ret;
    }
    // 递归删除二分搜索树最小节点，并返回新根
    private Node removeMin(Node node){
        if (node.left == null){
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }
    // 从二分搜索树中删除最大值所在节点, 返回最小值
    public E removeMax() {
        E ret = maxnum();
        root = removeMax(root);
        return ret;
    }
    // 递归删除二分搜索树最小节点，并返回新根
    private Node removeMax(Node node){
        if (node.right == null){
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //从二分搜索树中删除元素为e的节点
    public void remove(E e){
       root = remove(root,e);
    }
    private Node remove(Node node, E e) {
        if (node == null){
            return null;
        }
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else {
            // 右子树为空
            if (node.right == null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }
            // 左子树为空
            else if (node.left == null){
                Node right = node.right;
                node.right = null;
                size--;
                return right;
            }
            else {
                Node mininum = mininum(node.right);
                mininum.right = removeMin(node.right);
                mininum.left = node.left;
                node.left = node.right = null;
                return mininum;
            }
        }
    }


}
