package LeetCodeSecond.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: wky233
 * @Date: 2020/7/24 22:02
 * @Description:
 */
public class LeetCode_676 {
    /** Initialize your data structure here. */
    private Node root;
    public LeetCode_676() {
        root = new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            addWord(str);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return search(word,root,0,0);
    }
    // 递归
    public boolean search(String word, Node root, int cur, int diff){
        if (cur == word.length() && diff == 1 && root.isWord){
            return true;
        }
        if (cur > word.length() || diff > 1){
            return false;
        }
        char ch = word.charAt(cur);
        boolean mark = false;
        for (Map.Entry<Character,Node>  entry : root.next.entrySet()) {
            if (mark){
                return true;
            }
            if (ch == entry.getKey()){
                mark = search(word, entry.getValue(), cur + 1, diff);
            }else {
                mark = search(word, entry.getValue(), cur + 1, diff + 1);
            }
        }
        return mark;
    }
    public void addWord(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }
    private class Node{
        public TreeMap<Character, Node> next;
        public boolean isWord;

        public Node() {
            next = new TreeMap<>();
        }
    }
}
