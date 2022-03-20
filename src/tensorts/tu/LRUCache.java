package tensorts.tu;


import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/8/14 10:27
 * @Description:
 */
public class LRUCache {
    private HashMap<Integer,LinkNode> cached = new HashMap<>();
    private LinkNode head;
    private LinkNode tail;
    private int capcity;
    private int size;

    public LRUCache(int capcity) {
        this.capcity = capcity;
        head = new LinkNode();
        tail = new LinkNode();
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int key){
        LinkNode linkNode = cached.get(key);
        if (linkNode == null){
            return -1;
        }else {
            moveToHead(linkNode);
        }
        return linkNode.value;
    }
    public void put(int key, int val){
        LinkNode node = cached.get(key);
        if (node == null){
            node = new LinkNode(key, val);
            addHead(node);
            size++;
            cached.put(key,node);
            if (size > capcity){
                LinkNode last = removeLast();
                cached.remove(last.key);
                size--;
            }
        }else {
            node.value = val;
            moveToHead(node);
        }
    }

    private LinkNode removeLast() {
       LinkNode pre  = tail.pre;
       pre.pre.next = pre.next;
       pre.next.pre = pre.pre;
       return pre;
    }

    private void moveToHead(LinkNode linkNode) {
        moveNode(linkNode);
        addHead(linkNode);
    }

    private void addHead(LinkNode linkNode) {
        linkNode.next = head.next;
        head.next.pre = linkNode;
        head.next = linkNode;
        linkNode.pre = head;
    }

    private void moveNode(LinkNode linkNode) {
        linkNode.pre.next = linkNode.next;
        linkNode.next.pre = linkNode.pre;
    }

    private class LinkNode{
        LinkNode pre;
        LinkNode next;
        int key;
        int value;
        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public LinkNode(){

        }
    }
}


