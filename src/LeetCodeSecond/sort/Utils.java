package LeetCodeSecond.sort;


import LeetCodeSecond.linkedlist.ListNode;
import LeetCodeSecond.tree.TreeNode;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author 武凯焱
 * @date 2019/7/22 15:07
 * @Description:
 */

public class Utils {
    /**
     * 生成一个指定长度的随机数组
     *
     * @param length 长度
     * @param min
     * @param max
     * @return
     */
    public static int[] getRandomArr(int length, int min, int max) {
        int arr[] = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(max - min + 1) + min;
        }
        return arr;
    }

    public static void show(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + ",";
        }
        System.out.println(str.substring(0, str.length() - 1));
    }

    public static ListNode creatListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            tail.next = listNode;
            tail = listNode;
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-> ");
            head = head.next;
        }
        System.out.println("null");
    }
    //创建二叉树
    public static TreeNode creatTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        //将数组的元素转换为二叉树的结点
        ArrayList<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            list.add(new TreeNode(nums[i]));
        }
        for (int i = 0; i <  nums.length/ 2  -1 ; i++) {
            list.get(i).left = list.get(2*i+1);
            list.get(i).right = list.get(2*i+2);
        }
        //list.size()/ 2 奇数时 小数约掉
        int index = list.size()/ 2  -1;
        list.get(index).right = list.get(index * 2 + 1);
        if (list.size() % 2 != 0){
            list.get(index).right = list.get(index * 2 + 2);
        }

        return list.get(0);
    }
    public static void printTreenode(TreeNode root) {
        if (root != null){
            System.out.print(root.val + " ");
            printTreenode(root.left);
            printTreenode(root.right);
        }
    }
}

