package tensorts;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/8/13 15:53
 * @Description:
 */

public class LRUCache {
    private LinkedNode head, tail;
    private Map<Integer, LinkedNode> cache = new HashMap<>();
    private int size;
    private int capcity;

    public LRUCache(int capcity) {
        this.size = 0;
        this.head = new LinkedNode();
        this.tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
        this.capcity = capcity;
    }
    public int get(int key){
        LinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }else {
            moveToHead(node);
            return node.value;
        }
    }
    public void put(int key, int value){
        LinkedNode node = cache.get(key);
        if (node == null){
            node = new LinkedNode(key, value);
            addHead(node);
            cache.put(key,node);
            size++;
            if (size > capcity){
                LinkedNode last = removeLast();
                if (last != null) {
                    cache.remove(last.key);
                    size--;
                }
            }
        }else {
            node.value = value;
            moveToHead(node);
        }

    }

    private LinkedNode removeLast() {
       LinkedNode pre = tail.pre;
       if (pre.pre == null){
           return null;
       }
       pre.pre.next = tail;
       tail.pre = pre.pre;
       return pre;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addHead(node);
    }


    private void addHead(LinkedNode node) {
        LinkedNode next =  head.next;
        node.next = next;
        node.pre = head;
        next.pre = node;
        head.next = node;
    }



    private void removeNode(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private class LinkedNode{
        int key;
        int value;
        LinkedNode pre;
        LinkedNode next;

        public LinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public LinkedNode() {
        }

    }
}
