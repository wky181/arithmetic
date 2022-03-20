package LeetCodeSecond.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/6/1 13:51
 * @Description:
 */
public class LRUCache {

    private Map<Integer,LinkedNode> cache = new HashMap<>();
    private int size;
    private int capcity;
    private LinkedNode head, tail;

    public LRUCache(int capacity) {
        size = 0;
        this.capcity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null){
            return -1;
        }else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);
        if (node != null){
            node.value = value;
            moveToHead(node);
        }else {
            node = new LinkedNode(key,value);
            cache.put(key,node);
            addToHead(node);
            ++size;
            if (size > capcity){
                LinkedNode tail =  removeTail();
                cache.remove(tail.key);
                --size;
            }
        }
    }

    private LinkedNode removeTail() {
        LinkedNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        return node;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkedNode node) {
        head.next.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next = node;
    }

    private void removeNode(LinkedNode node) {
        LinkedNode nodePrev =  node.prev;
        LinkedNode next = node.next;
        nodePrev.next = next;
        next.prev = nodePrev;
    }

    private class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LinkedNode() {
        }
    }


}
