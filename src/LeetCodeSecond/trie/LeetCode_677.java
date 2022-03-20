package LeetCodeSecond.trie;

import java.util.TreeMap;

/**
 * @Author: wky233
 * @Date: 2020/7/24 21:07
 * @Description:
 */
public class LeetCode_677 {

    private Node root;
    public LeetCode_677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c  = key.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
        cur.isWord = true;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }
    public int sum(Node node) {
        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    private class Node{
        public TreeMap<Character, Node> next;
        public boolean isWord;
        public int value;
        public Node() {
            next = new TreeMap<>();
        }
    }
}
