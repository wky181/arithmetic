package sort;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/9/8 22:57
 * @Description:
 */
public class LRU {
    private int capacity;
    HashMap<Integer,ListNode> hashMap;
    ListNode head, tail;
    public LRU(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }
    public void put(int key, int value){
       if (hashMap.containsKey(key)){
           ListNode listNode = hashMap.get(key);
           listNode.value = value;
           move2head(listNode);
       }else if (hashMap.size() < capacity){
           ListNode newNode = new ListNode(key,value);
           hashMap.put(key,newNode);
           addHead(newNode);
       }else {
           ListNode newNode = new ListNode(key,value);
           hashMap.put(key,newNode);
           addHead(newNode);
           removeLast();
       }
    }

    private int get(int key){
        if (!hashMap.containsKey(key)){
            return -1;
        }
       return move2head(hashMap.get(key));
    }

    private int move2head(ListNode listNode) {
        removeNode(listNode);
        addHead(listNode);
        return listNode.value;
    }


    private void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeLast() {
        ListNode node = tail.pre;
        node.pre.next = node.next;
        node.next.pre = node.pre;
        hashMap.remove(node.key);
    }

    private void addHead(ListNode newNode) {
        ListNode next = head.next;
        head.next = newNode;
        next.pre = newNode;
        newNode.next = next;
        newNode.pre = head;
    }

    private class ListNode{
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public ListNode() {

        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(10);
        for (int i = 0; i < 10; i++) {
            lru.put(i,i);
        }
        lru.get(1);
        lru.put(101,3);
        lru.put(102,7777);
        System.out.println(lru.get(1));
    }
}
