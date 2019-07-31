package 数据结构.lanqiao.list;

import leetcode.Utils;

/**
 * @author 武凯焱
 * @date 2019/7/29 11:35
 * @Description:
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr =Utils.getRandomArr(10,20,50);
        Utils.show(arr);
        sort(arr);
        Utils.show(arr);

    }

    private static void sort(int[] arr) {
        int length = arr.length;
        ListNode<Integer>[] bucket = new ListNode[length];
        int max = getMax(arr);
        for (int i = 0; i < arr.length; i++) {
            int index = hash(arr[i], max, length);
            if (bucket[index] == null) {
                bucket[index] = new ListNode<Integer>(arr[i]);
            } else {
                intserInto(arr[i],bucket[index],index,bucket);
            }
        }
        int k = 0;
        for (ListNode<Integer> listNode: bucket) {
            while (listNode!=null){
                arr[k++] = listNode.data;
                listNode = listNode.next;
            }
        }
    }

    private static int hash(int num, int max, int length) {
        return num / (max + 1) * length;
    }

    private static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * 插入有序单链表
     * @param value 要插入的值
     * @param head
     * @param hash 桶的下标
     * @param bucket
     */
    private static void intserInto(int value, ListNode<Integer> head, int hash, ListNode[] bucket) {
        ListNode<Integer> newNode = new ListNode<>(value);
        //判斷是否是插入头部
        if (value <= head.data) {
            newNode.next = head;
            bucket[hash] = newNode;
            return;
        }
        ListNode<Integer> p = head;
        ListNode<Integer> pre = null;
        while (p != null && value > p.data) {
            pre = p;
            p = p.next;
        }
        //判断是否到达尾部
        if (p==null){
            pre.next = newNode;
        }else {
            pre.next = newNode;
            newNode.next=p;
        }
    }

}
